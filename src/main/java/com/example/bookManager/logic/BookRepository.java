package com.example.bookManager.logic;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    // CRUD
    void save(Libro book);

    List<Libro> findAll();

    void deleteByIsbn(String isbn);

    Optional<Libro> findByIsbn(String isbn);
}
