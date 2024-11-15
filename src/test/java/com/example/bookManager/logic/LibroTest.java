package com.example.bookManager.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {
    @Test
    void  canCreateLibro(){
        //crear un objeto libro
        Libro libro = new Libro("A123","El cielo","Adan R.");
        //verificar los valores asignados son correctos
        assertEquals("A123", libro.getIsbn());
        assertEquals("El cielo",libro.getTitle());
        assertEquals("Adan R.",libro.getAuthor());
    }

}