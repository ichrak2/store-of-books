package com.app.store.services;

import com.app.store.entity.Book;

import java.util.List;
import java.util.UUID;

/**
 * The interface book service define services : create , update , findAll , findById .
 */
public interface BookService {
    /**
     * Create book.
     *
     * @param book the book
     * @return the book
     */
    Book create(Book book);

    /**
     * Update book.
     *
     * @param book the book
     * @return the book
     */
    Book update(Book book);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(UUID id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Book> findAll();

    /**
     * Find by id book.
     *
     * @param id the id
     * @return the book
     */
    Book findById(UUID id);
}
