package com.example.bookManager.presentation;

import com.example.bookManager.logic.Book;
import com.example.bookManager.logic.BookManager;
import com.example.bookManager.logic.BookRepository;

import com.example.bookManager.persitence.InMemoryBookRepository;
import com.example.bookManager.persitence.MySQLBookRepository;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final BookManager bookManager;
    private final BookRepository inMemoryRepository;
    private final BookRepository mySqlRepository;

    private Scanner sc = new Scanner(System.in);

    public ConsoleView() {
        this.bookManager = new BookManager(new MySQLBookRepository());

        this.inMemoryRepository = new InMemoryBookRepository();
        this.mySqlRepository = new MySQLBookRepository();
    }

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
                    optionSelector(option);
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
        if (option == 4) this.printChangeRepository();

    }

    private  void  printChangeRepository() {
        System.out.println("Selecciona el tipo de repositorio");
        System.out.println("1. Memoria");
        System.out.println("2. Base de datos MySQL");
        System.out.println("Seleccione una opción");

        String optionRepository = sc.nextLine();

        if (optionRepository.equals("1")){
            bookManager.changeRepository(inMemoryRepository);
            System.out.println("Se cambió al repositorio de memoria");
        }
        if (optionRepository.equals("2")) {
            bookManager.changeRepository(mySqlRepository);
            System.out.println("Se cambió al repositorio Base de datos");
        }

    }

    private void printAddBookMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.println(" Introduce el isbn. (El campo no puede estar vacio)");
        String isbn = sc.nextLine();

        System.out.println("introduce titulo. (El campo no puede estar vacío)");
        String titulo = sc.nextLine();

        System.out.println("Introduce autor. (El campo no puede estar vacío.)");
        String autor = sc.nextLine();
        try {
            this.bookManager.createBook(isbn, titulo, autor);
            System.out.println("El libro se ha añadido con éxito");
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
        List<Book> bookList = bookManager.getAllBook();
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }

}

