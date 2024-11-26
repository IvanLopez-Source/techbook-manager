package com.example.bookManager.persitence;

import com.example.bookManager.logic.BookRepository;
import com.example.bookManager.logic.Book;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository {
    private static final List<Book> booksDB = new ArrayList<>();

    @Override
    public void save(Book book) {
        for (Book existingBook : booksDB) {
            if (existingBook.getIsbn().equals(existingBook.getIsbn())) {
                throw new IllegalArgumentException("Ya existe un libro con ese ISBN. No se puede añadir el libro.");
            }
        }

        booksDB.add(book);
    }

    @Override
    public List<Book> findAll() {
        return booksDB;
    }

    @Override
    public void deleteByIsbn(String isbn) {
        booksDB.removeIf(book -> book.getIsbn().equals(isbn));
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {

        return Optional.empty();
    }
}
