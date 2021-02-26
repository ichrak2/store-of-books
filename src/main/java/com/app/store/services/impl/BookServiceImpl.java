package com.app.store.services.impl;

import com.app.store.entity.Book;
import com.app.store.entity.BookNotFoundException;
import com.app.store.repositories.BookRepository;
import com.app.store.services.BookService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements the methods of book service interface.
 */
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    /**
     * Instantiates a new Book service.
     *
     * @param bookRepository the book repository
     */
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public void delete(UUID id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(UUID id) {
        return this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

}
