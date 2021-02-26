package com.app.store.services;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import com.app.store.entity.Book;
import com.app.store.entity.Comment;
import com.app.store.repositories.BookRepository;
import com.app.store.repositories.CommentRepository;
import com.app.store.services.impl.CommentServiceImpl;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Class test for Comment service.
 */
@ExtendWith(MockitoExtension.class)
class CommentServiceTest {
    /**
     * Mock The Book repository.
     */
    @Mock
    BookRepository bookRepository;
    /**
     * Mock The Comment repository.
     */
    @Mock
    CommentRepository commentRepository;
    /**
     * Inject The Comment service.
     */
    @InjectMocks
    CommentServiceImpl commentServiceImpl;

    /**
     * Assert that the the comment added to the book is the one given .
     */
    @Test
    void should_add_a_comment_to_book() {
        var id = UUID.randomUUID();
        var commentText = "comment";
        Comment comment = new Comment(0, commentText);
        Book book = new Book(id, "book", new ArrayList<>());
        given(bookRepository.findById(id)).willReturn(Optional.of(book));
        given(bookRepository.save(book)).willReturn(book);

        // then
        assertThatCode(
                () -> {
                    commentServiceImpl.add(id, comment);
                })
                .doesNotThrowAnyException();
    }

    /**
     * Assert that the comment updated is the correct one.
     */
    @Test
    void should_update_a_comment() {
        // given
        var idComment = 1;
        var commentText = "comment";
        Comment comment = new Comment(idComment, commentText);
        Comment expected = new Comment(idComment, "updated comment");
        given(commentRepository.save(expected)).willReturn(expected);
        // when
        Comment actual = commentServiceImpl.update(expected);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
