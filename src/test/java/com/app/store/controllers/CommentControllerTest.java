package com.app.store.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.app.store.entity.Comment;
import com.app.store.rest.CommentController;
import com.app.store.services.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * The type Comment controller test.
 */
@WebMvcTest(controllers = CommentController.class)
class CommentControllerTest {
    /**
     * MockThe Comment service.
     */
    @MockBean
    CommentService commentService;
    /**
     * Inject the Mock mvc.
     */
    @Autowired
    MockMvc mockMvc;

    /**
     * Test if the method findById returns a book by id or not.
     *
     * @throws Exception the exception
     */
    @Test
    void should_return_a_book_by_id() throws Exception {
        int id = 1;
        given(commentService.findById(id)).willReturn(new Comment(1, "comment"));

        mockMvc
                .perform(get("/comments/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.commentText", is("comment")));
    }
}
