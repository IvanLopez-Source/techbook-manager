package com.example.bookManager;


import com.example.bookManager.presentation.Application;

public class Main {

    public static void main(String[] args) {
        Application menu = new Application();
        menu.imprimir();

//        Caso de uso: guardar libro
//        MySQLBookRepository bookRepository = new MySQLBookRepository();
//
//        Libro newBook = new Libro ("C234", "Clean Architecture", "Uncle Bob" );
//        bookRepository.save(newBook);
//        bookRepository.deleteByIsbn("C234");
//
//        List<Libro> list = bookRepository.findAll();
//        for (Libro book : list) {
//            System.out.println(book);
//        }
//
//        Optional<Libro> optionalBook = bookRepository.findByIsbn("C234");
//
//        if (optionalBook.isPresent()) {
//            Libro book = optionalBook.get();
//            System.out.println(book);
//        }
//        if (optionalBook.isEmpty()) {
//            System.out.println("El libro no se encuentra");
//        }

    }


}


