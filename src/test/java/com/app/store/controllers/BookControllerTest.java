package com.app.store.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.app.store.entity.Book;
import com.app.store.rest.BookController;
import com.app.store.services.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Class test for Book controller.
 */
@WebMvcTest(controllers = BookController.class)
class BookControllerTest {
    /**
     * Mock The Book service.
     */
    @MockBean
    BookService bookService;
    /**
     * Inject The Mock mvc.
     */
    @Autowired
    MockMvc mockMvc;

    /**
     * Test if the method create returns a book or not.
     *
     * @throws Exception the exception
     */
    @Test
    void should_create_a_book() throws Exception {
        var book = new Book(null, "book", new ArrayList<>());
        var id = UUID.randomUUID();
        given(bookService.create(book)).willReturn(new Book(id, "book", new ArrayList<>()));

        mockMvc
                .perform(
                        post("/books")
                                .content(new ObjectMapper().writeValueAsString(book))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
    }

    /**
     * Test if the method update updates a book and return it or not.
     *
     * @throws Exception the exception
     */
    @Test
    void should_update_a_book() throws Exception {
        var id = UUID.randomUUID();
        var book = new Book(id, "book", new ArrayList<>());
        given(bookService.update(book)).willReturn(book);

        mockMvc
                .perform(
                        put("/books")
                                .content(new ObjectMapper().writeValueAsString(book))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.name").value("book"));
    }

    /**
     * Test if the method findAll returns a list of books or not.
     *
     * @throws Exception the exception
     */
    @Test
    void should_return_list_of_books() throws Exception {
        var bookList =
                List.of(
                        new Book(UUID.randomUUID(), "book1", new ArrayList<>()),
                        new Book(UUID.randomUUID(), "book2", new ArrayList<>()),
                        new Book(UUID.randomUUID(), "book3", new ArrayList<>()));
        given(bookService.findAll()).willReturn(bookList);

        mockMvc
                .perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]").exists())
                .andExpect(jsonPath("$.[*].id").isNotEmpty());
    }

    /**
     * Test if the method findById returns a book by id or not.
     *
     * @throws Exception the exception
     */
    @Test
    void should_return_a_book_by_id() throws Exception {
        var id = UUID.randomUUID();
        given(bookService.findById(id)).willReturn(new Book(id, "book", new ArrayList<>()));

        mockMvc
                .perform(get("/books/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id.toString())))
                .andExpect(jsonPath("$.name", is("book")));
    }

    /**
     * Test if the method delete deletes a book by id or not.
     *
     * @throws Exception the exception
     */
    @Test
    void should_delete_a_book_by_id() throws Exception {
        var id = UUID.randomUUID();
        doNothing().when(bookService).delete(id);

        mockMvc.perform(delete("/books/{id}", id)).andExpect(status().isOk());
    }
}
