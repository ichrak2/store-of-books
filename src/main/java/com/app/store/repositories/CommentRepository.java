package com.app.store.repositories;

import com.app.store.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Comment repository which extends JpaRepository by extending JpaRepository we get a
 * bunch of generic CRUD methods into our type that allows : saving comments to a specific book,
 * deleting them , updating them , searching for them and so on.
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
