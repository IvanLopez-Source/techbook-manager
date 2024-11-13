package com.example.bookManager.persitence;

import com.example.bookManager.logic.BookRepository;
import com.example.bookManager.logic.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository {
    private static List<Libro> booksDB = new ArrayList<>();

    @Override
    public void save(Libro book) {
        booksDB.add(book);
    }

    @Override
    public List<Libro> findAll() {
        return booksDB;
    }

    @Override
    public void deleteByIsbn(String isbn) {
        booksDB.removeIf(book -> book.getIsbn().equals(isbn));
    }

    @Override
    public Optional<Libro> findByIsbn(String isbn) {

        return Optional.empty();
    }
}
