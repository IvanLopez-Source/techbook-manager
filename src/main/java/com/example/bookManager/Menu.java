package com.example.bookManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Libro> lista = new ArrayList<>();
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
        if (option == 1) this.addBook();
        if (option == 2) this.printBookList(lista);
        if (option == 3) this.deleteBook();
    }

    private void addBook() {

        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println(" Introdusca el isbn. (El campo no puede estar vacio)");
            String isbn = sc.nextLine();
            for (Libro libro : lista) {
                if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                    System.out.println("Ya existe un libro con ese ISBN. No se puede añadir el libro.");
                    return;
                }
            }
            if (!isbn.matches("^[A-Za-z]\\d{3}$")) {
                System.out.println("Ingrese una letra seguida de tres números");

                continue;
            }
            ;

            System.out.println("introduce titulo. (El campo no puede estar vacío)");
            String titulo = sc.nextLine();

            System.out.println("Introduce autor. (El campo no puede estar vacío.)");
            String autor = sc.nextLine();

            if (isbn.trim().isEmpty() || titulo.trim().isEmpty() || autor.trim().isEmpty()) {
                System.out.println("Todos los campos son obligatorios. Por favor, intente nuevamente.");

            } else {
                Libro libro = new Libro(isbn, titulo, autor);
                lista.add(libro);
                printBookList(lista);
                System.out.println("El libro añadido con éxito.");
            }

            break;

        }
    }


    private void deleteBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el ISBN del libro a eliminar: ");
        String isbn = sc.nextLine();

        Libro libroAEliminar = null;
        for (Libro libro : lista) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                libroAEliminar = libro;
                break;
            }
        }

        if (libroAEliminar != null) {
            lista.remove(libroAEliminar);
            System.out.println("El libro con ISBN " + isbn + " ha sido eliminado.");
        } else {
            System.out.println("No se encontró ningún libro con el ISBN especificado.");
        }
    }

    private void printBookList(List<Libro> listaLibros) {

        if (listaLibros.size() == 0) {
            System.out.println("La lista de libros está vacía.");
            return;
        }
        System.out.println(lista);

    }


}

