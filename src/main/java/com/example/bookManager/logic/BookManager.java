package com.example.bookManager.logic;

import com.example.bookManager.persitence.MySQLBookRepository;

import java.util.List;
import java.util.Optional;

public class BookManager {
    private BookRepository bookRepository;

    // inversion de dependencias (SOLID) Dependency Inversion Principle

    public BookManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBook(String isbn, String titulo, String autor) {
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);


        if (optionalBook.isPresent()) {
            throw new IllegalArgumentException("Ya existe un Book con ese ISBN. No se puede añadir el Book.");
        }


        if (!isbn.matches("^[A-Za-z]\\d{3}$")) {
            throw new IllegalArgumentException("En el ISBN ingrese una letra seguida de tres números");
        }
        ;

        if (isbn.trim().isEmpty() || titulo.trim().isEmpty() || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios. Por favor, intente nuevamente.");

        }

        Book Book = new Book(isbn, titulo, autor);
        bookRepository.save(Book);

    }

    public void deleteBook(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public void changeRepository(BookRepository newRespository){
        this.bookRepository= newRespository;

    }
}