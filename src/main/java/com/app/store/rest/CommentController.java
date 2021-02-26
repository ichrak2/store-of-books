package com.app.store.rest;

import com.app.store.entity.Comment;
import com.app.store.services.CommentService;

import java.util.UUID;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

/**
 * The Comment rest controller.
 */
@RestController
@RequestMapping("/comments")
@Log4j2
public class CommentController {
    private final CommentService commentService;

    /**
     * Instantiates a new Comment controller.
     *
     * @param commentService the comment service
     */
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Get comment by id.
     *
     * @param id the id
     * @return the comment
     */
    @GetMapping("/{id}")
    public Comment getById(@PathVariable int id) {

        log.info("you are getting the comment with the id {}", id);
        return this.commentService.findById(id);
    }

    /**
     * Add a comment to a Book.
     *
     * @param idBook  the id book
     * @param comment the comment
     */
    @PostMapping("/{idBook}")
    public void save(@PathVariable UUID idBook, @RequestBody Comment comment) {
        log.info("you added this comment to the book with id {}", idBook);
        this.commentService.add(idBook, comment);
    }

    /**
     * Delete a comment.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        log.info("you deleted the comment with id {}", id);
        this.commentService.delete(id);
    }

    /**
     * Update a comment.
     *
     * @param comment the comment
     * @return the comment
     */
    @PutMapping
    public Comment update(@RequestBody Comment comment) {
        log.info("you updated the comment : {} ", comment);
        return this.commentService.update(comment);
    }
}
