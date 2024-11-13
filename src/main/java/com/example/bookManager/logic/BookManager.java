package com.example.bookManager.logic;

import com.example.bookManager.persitence.MySQLBookRepository;

import java.util.List;
import java.util.Optional;

public class BookManager {
    private BookRepository bookRepository = new MySQLBookRepository();



    public void createBook(String isbn, String titulo, String autor) {
        Optional<Libro> optionalLibro = bookRepository.findByIsbn(isbn);


        if (optionalLibro.isPresent()) {
            throw new IllegalArgumentException("Ya existe un libro con ese ISBN. No se puede añadir el libro.");
        }


        if (!isbn.matches("^[A-Za-z]\\d{3}$")) {
            throw new IllegalArgumentException("En el ISBN ingrese una letra seguida de tres números");
        }
        ;

        if (isbn.trim().isEmpty() || titulo.trim().isEmpty() || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios. Por favor, intente nuevamente.");

        }

        Libro libro = new Libro(isbn, titulo, autor);
        bookRepository.save(libro);


    }

    public void deleteBook(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public List<Libro> getAllBook() {
        return bookRepository.findAll();
    }
}