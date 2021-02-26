package com.app.store.services;

import com.app.store.entity.Comment;

import java.util.List;
import java.util.UUID;

/**
 * The interface Comment service define services : create , update , findAll , findById .
 */
public interface CommentService {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<Comment> findAll();

    /**
     * Delete.
     *
     * @param idComment the id comment
     */
    void delete(int idComment);

    /**
     * Add.
     *
     * @param idBook  the id book
     * @param comment the comment
     */
    void add(UUID idBook, Comment comment);

    /**
     * Update comment.
     *
     * @param comment the comment
     * @return the comment
     */
    Comment update(Comment comment);

    /**
     * Find by id comment.
     *
     * @param id the id
     * @return the comment
     */
    Comment findById(int id);
}
