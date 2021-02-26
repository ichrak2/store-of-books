package com.app.store.entity;

/**
 * this is an exception class
 *
 * @throws RuntimeException if the book is not found
 */
public class BookNotFoundException extends RuntimeException {

    /**
     * Instantiates a new Book not found exception.
     */
    public BookNotFoundException() {
        super("book not found");
    }
}
