package com.example.bookManager.persitence;

import com.example.bookManager.logic.BookRepository;
import com.example.bookManager.config.MySqlConnection;
import com.example.bookManager.logic.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySQLBookRepository implements BookRepository {

    // CRUD
    @Override
    public void save(Libro book) {
        String sql = "INSERT INTO books (isbn, title, author) VALUES (?, ?, ?)";


        try(Connection connection = MySqlConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());

            statement.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Libro> findAll() {
        String sql = "SELECT * FROM books";
        List<Libro> booksList = new ArrayList<>();
        try {
            Connection connection = MySqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(sql);


            while (res.next()) {
                String isbn = res.getString("isbn");
                String title = res.getString("title");
                String author = res.getString("author");

                Libro book = new Libro(isbn, title, author);
                booksList.add(book);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return booksList;
    }

    @Override
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

    @Override
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
