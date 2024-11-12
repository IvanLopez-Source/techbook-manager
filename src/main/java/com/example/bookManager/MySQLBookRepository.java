package com.example.bookManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySQLBookRepository {

    // CRUD
    public void save(Libro book) {
        String sql = "INSERT INTO books (isbn, title, author) VALUES ('%s', '%s', '%s')"
                .formatted(book.getIsbn(), book.getTitle(), book.getAuthor());

        System.out.println(sql);
        //try with resources

        try{
            Connection connection = MySqlConnection.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public List<Libro> findAll(){
        String sql = "SELECT * FROM books";
        List<Libro> booksList = new ArrayList<>();
        try {
            Connection connection = MySqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);


            while ( res.next()){
                String isbn = res.getString("isbn");
                String title = res.getString("title");
                String author = res.getString("author");

                Libro book = new Libro(isbn, title, author);
                booksList.add(book);
            }

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return booksList;
    }

    public void deleteByIsbn(String isbn) {
        String sql = "DELETE FROM books WHERE isbn='%s'".formatted(isbn);
        try {
            Connection connection = MySqlConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

  public Optional<Libro> findByIsbn(String isbn) {
        String sql = "SELECT * FROM books WHERE isbn= '%s'".formatted(isbn);
        try {
            Connection connection = MySqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);

            // mirar si hay un resultado
            if (res.next()) {
                Libro book = new Libro(res.getString("isbn"),
                        res.getString("title"),
                        res.getString("author"));
                return Optional.of(book);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }
}
