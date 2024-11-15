package com.example.bookManager.logic;

import static org.junit.jupiter.api.Assertions.*;

import com.example.bookManager.persitence.InMemoryBookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class BookManagerTest {

    private InMemoryBookRepository bookRepository;
    private BookManager bookManager;

    @BeforeEach

    public void setUp() {
        bookRepository = new InMemoryBookRepository();
        bookManager = new BookManager(bookRepository);
    }

    @Test
    public void testCreateBook_SuccessfulCreation() {
        String isbn = "A123";
        String titulo = "Libro de prueba";
        String autor = "Autor de prueba";


        bookManager.createBook(isbn, titulo, autor);

        List<Libro> libros = bookManager.getAllBook();
        assertEquals(1, libros.size());
        assertEquals(isbn, libros.get(0).getIsbn());

    }
    @Test
    public  void testDeleteBook(){
        String isbn = "A123";
        String titulo = "Libro de prueba";
        String autor = "Autor de prueba";

        bookManager.createBook(isbn, titulo, autor);
        bookManager.deleteBook(isbn);
        List<Libro> libros = bookManager.getAllBook();
        assertTrue(libros.isEmpty());
    }

}
