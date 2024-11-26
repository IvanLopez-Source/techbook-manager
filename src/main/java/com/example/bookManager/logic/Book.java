package com.example.bookManager.logic;

public class Book {
    private String isbn;
    private String title;
    private String author;

    public Book(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.title = titulo;
        this.author = autor;
    }

    public String getIsbn() {
        return isbn;
    }


    @Override
    public String toString() {
        return "Libro " +
                "ISBN: " + isbn + " - " +
                "Titulo: " + title + " - " +
                "Autor: " + author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
