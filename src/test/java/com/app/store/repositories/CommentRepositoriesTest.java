package com.app.store.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.store.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Class test for Comment repositories.
 */
@DataJpaTest
class CommentRepositoriesTest {
    /**
     * Inject The Test entity manager.
     */
    @Autowired
    TestEntityManager testEntityManager;
    /**
     * Inject The Comment repository.
     */
    @Autowired
    CommentRepository commentRepository;

    /**
     * Test if the comment returned is the one expected or not.
     */
    @Test
    void should_return_comment_by_id() {
        // given
        var comment = new Comment(0, "test");
        testEntityManager.persist(comment);
        comment.setId(1);
        // when
        var expected = commentRepository.findById(1);

        // then
        assertThat(comment).isEqualTo(expected.get());
    }
}
