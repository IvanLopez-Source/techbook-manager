package com.example.bookManager;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    public List<Libro> bookList = new ArrayList<Libro>();

    public BookManager() {
    }

    public void createBook(String isbn, String titulo, String autor, Application application) {

        for (Libro libro : bookList) {

            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                throw new IllegalArgumentException("Ya existe un libro con ese ISBN. No se puede añadir el libro.");
            }
        }
        if (!isbn.matches("^[A-Za-z]\\d{3}$")) {
            throw new IllegalArgumentException("En el ISBN ingrese una letra seguida de tres números");
        }
        ;

        if (isbn.trim().isEmpty() || titulo.trim().isEmpty() || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios. Por favor, intente nuevamente.");

        }
        Libro libro = new Libro(isbn, titulo, autor);
        bookList.add(libro);

    }

    public void deleteBook(String isbn) {

        if (bookList.stream().noneMatch(libro -> libro.getIsbn().equalsIgnoreCase(isbn))) {
            throw new IllegalArgumentException("No se encontró ningún libro con el ISBN especificado.");
        }

        bookList.removeIf(libro -> libro.getIsbn().equalsIgnoreCase(isbn));

    }

    public void emptyBookList(List<Libro> listaLibros) {
        if (listaLibros.isEmpty()) {
            throw new IllegalArgumentException("No hay libros en la lista.");
        }
    }
}