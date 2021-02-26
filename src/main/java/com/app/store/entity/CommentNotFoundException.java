package com.app.store.entity;

/**
 * this is an exception class
 *
 * @throws RuntimeException if the comment is not found
 */
public class CommentNotFoundException extends RuntimeException {
    /**
     * Instantiates a new Comment not found exception.
     */
    public CommentNotFoundException() {
        super("comment not found");
    }
}
