package com.example.bookManager.presentation;

import com.example.bookManager.logic.BookManager;
import com.example.bookManager.logic.Libro;

import java.util.List;
import java.util.Scanner;

public class Application {
    private final BookManager bookManager = new BookManager();
    private Scanner sc = new Scanner(System.in);

    Libro libro1 = new Libro("A123", "Java", "java");


    public void imprimir() {

        int option;
        Scanner sc = new Scanner(System.in);
        String[] menu = {
                "1. Añadir Libro",
                "2. Ver todos los libros",
                "3. Eliminar libro",
                "4. Cambiar Repositorio",
                "5. Salir"
        };
        do {

            for (String item : menu) {
                System.out.println(item);
            }

            System.out.println("Select the option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Option 1: Añadir Libro");
                    optionSelector(option);
                    break;
                case 2:
                    System.out.println("Option 2: Ver todos los libros");
                    optionSelector(option);
                    break;
                case 3:
                    System.out.println("Option 3: Eliminar libro");
                    optionSelector(option);
                    break;
                case 4:
                    System.out.println("Option 4: Cambiar Repositorio");
                    break;
                case 5:
                    System.out.println("Option 5: Salir");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (option != 5);
    }

    private void optionSelector(int option) {
        if (option == 1) this.printAddBookMenu();
        if (option == 2) this.printBookList();
        if (option == 3) this.printDeleteBook();
    }

    private void printAddBookMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.println(" Introdusca el isbn. (El campo no puede estar vacio)");
        String isbn = sc.nextLine();

        System.out.println("introduce titulo. (El campo no puede estar vacío)");
        String titulo = sc.nextLine();

        System.out.println("Introduce autor. (El campo no puede estar vacío.)");
        String autor = sc.nextLine();
        try {
            this.bookManager.createBook(isbn, titulo, autor);
            System.out.println("El libro añadido con éxito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private void printDeleteBook() {

        System.out.print("Introduce el ISBN del libro a eliminar: ");
        String isbn = sc.nextLine();
        try {
            this.bookManager.deleteBook(isbn);
            System.out.println("El libro con ISBN " + isbn + " ha sido eliminado.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void printBookList() {
        List<Libro> bookList = bookManager.getAllBook();
        for (Libro book : bookList) {
            System.out.println(book.toString());
        }
    }

}

