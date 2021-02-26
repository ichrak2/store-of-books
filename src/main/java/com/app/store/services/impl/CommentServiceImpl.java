package com.app.store.services.impl;

import com.app.store.entity.BookNotFoundException;
import com.app.store.entity.Comment;
import com.app.store.entity.CommentNotFoundException;
import com.app.store.repositories.BookRepository;
import com.app.store.repositories.CommentRepository;
import com.app.store.services.CommentService;

import java.util.List;
import java.util.UUID;

/**
 * This class implements the methods of comment service interface .
 */
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    /**
     * Instantiates a new Comment service.
     *
     * @param commentRepository the comment repository
     * @param bookRepository    the book repository
     */
    public CommentServiceImpl(CommentRepository commentRepository, BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return this.commentRepository.findAll();
    }

    @Override
    public void delete(int idComment) {
        this.commentRepository.deleteById(idComment);
    }

    @Override
    public void add(UUID idBook, Comment comment) {
        this.bookRepository.save(
                this.bookRepository
                        .findById(idBook)
                        .orElseThrow(BookNotFoundException::new)
                        .addComment(comment));
    }

    @Override
    public Comment update(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public Comment findById(int id) {
        return this.commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
    }
}
