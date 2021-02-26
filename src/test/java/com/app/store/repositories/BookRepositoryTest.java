package com.app.store.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.store.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Class test for Book repository.
 */
@DataJpaTest
class BookRepositoryTest {
    /**
     * Inject The Test entity manager.
     */
    @Autowired
    TestEntityManager testEntityManager;
    /**
     * Inject The Book repository.
     */
    @Autowired
    BookRepository bookRepository;

    /**
     * Test if the book returned is the one expected or not.
     */
    @Test
    void should_return_book_by_id() {
        // given
        var book = new Book();
        book.setName("book");
        var idBook = book.getId();
        testEntityManager.persist(book);
        // when
        var actual = bookRepository.findById(idBook);
        // then
        assertThat(book).isEqualTo(actual.get());
    }
}
