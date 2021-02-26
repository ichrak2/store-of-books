package com.app.store.repositories;

import com.app.store.entity.Book;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Book repository which extends JpaRepository by extending JpaRepository we get a
 * bunch of generic CRUD methods into our type that allows : saving books, deleting them , updating
 * them , searching for them and so on.
 */
public interface BookRepository extends JpaRepository<Book, UUID> {
}
