package com.app.store;

import com.app.store.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerIntegrationTest {
    @LocalServerPort
    int port;
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void should_create_a_book() {
        //given
        var uri = "http://localhost:" + port + "/books";
        var book = new Book("book", new ArrayList<>());
        //when
        var bookResponseEntity =
                testRestTemplate.postForEntity(uri, book, Book.class);
        //then
        bookResponseEntity.getStatusCode().is2xxSuccessful();
        assertThat(bookResponseEntity.getBody()).isNotNull();
    }

    @Test
    void should_return_book_by_id() {
        //given
        var id = UUID.fromString("e27294b9-8402-4f90-81ed-357c7bbc7a70");
        var uri = "http://localhost:" + port + "/books/" + id.toString();
        //when
        var bookResponseEntity = testRestTemplate.getForEntity(uri, Book.class);
        //then
        bookResponseEntity.getStatusCode().is2xxSuccessful();
        assertThat(bookResponseEntity.getBody().getName()).isEqualTo("book dataBase");
    }

    @Test
    void should_update_a_book_by_id() {
        //given
        var id = UUID.fromString("e27294b9-8402-4f90-81ed-357c7bbc7a70");
        var uri = "http://localhost:" + port + "/books/" + id.toString();
        var putURI = "http://localhost:" + port + "/books";
        var book = new Book(id, "book", new ArrayList<>());
        //when
        testRestTemplate.put(putURI, book, Book.class);
        var bookResponseEntity = testRestTemplate.getForEntity(uri, Book.class);
        //then
        bookResponseEntity.getStatusCode().is2xxSuccessful();
        assertThat(bookResponseEntity.getBody().getName()).isEqualTo("book");
    }

    @Test
    void should_return_List_of_books() {
        //given
        var uri = "http://localhost:" + port + "/books";
        //when
        var bookResponseEntity =
                testRestTemplate.getForEntity(
                        uri, List.class);
        //then
        bookResponseEntity.getStatusCode().is2xxSuccessful();
        assertThat(bookResponseEntity.getBody()).isNotNull();
    }

    @Test
    void should_delete_a_book_by_id() {
        //given
        var id = UUID.fromString("e27294b9-8402-4f90-81ed-357c7bbc7a70");
        var uri = "http://localhost:" + port + "/books/" + id.toString();
        //when
        testRestTemplate.delete(uri);
        var bookResponseEntity = testRestTemplate.getForEntity(uri, Book.class);
        //then
        assertThat(bookResponseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
