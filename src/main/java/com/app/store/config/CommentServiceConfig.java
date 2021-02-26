package com.app.store.config;

import com.app.store.repositories.BookRepository;
import com.app.store.repositories.CommentRepository;
import com.app.store.services.CommentService;
import com.app.store.services.impl.CommentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * instantiate the commentService.
 */
@Configuration
public class CommentServiceConfig {
    /**
     * Comment service.
     *
     * @param commentRepository the comment repository
     * @param bookRepository    the book repository
     * @return the comment service
     */
    @Bean
    public CommentService commentService(CommentRepository commentRepository, BookRepository bookRepository) {
        return new CommentServiceImpl(commentRepository, bookRepository);
    }
}
