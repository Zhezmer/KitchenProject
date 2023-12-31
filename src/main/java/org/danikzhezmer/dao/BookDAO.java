package org.danikzhezmer.dao;

import org.danikzhezmer.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class BookDAO {
    public Book getBookById(int id) {
        String sql = "SELECT  title, author FROM book WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Book book = new Book();
                    book.setAuthor(resultSet.getString("author"));
                    book.setTitle(resultSet.getString("title"));
                    return book;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<Integer, Book> getAll() throws SQLException {
        String sql = "SELECT * FROM book";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                HashMap<Integer, Book> res = new HashMap<>();

                while (resultSet.next()) {
                    Book book = new Book();
                    book.setAuthor(resultSet.getString("author"));
                    book.setTitle(resultSet.getString("title"));
                    res.put(resultSet.getInt("id"), book);
                }
                return res;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public int createBook(Book book) {
        String sql = "INSERT INTO book (title, author) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return getLastId();
            } else {
                throw new RuntimeException("Couldn't save person");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    private int getLastId(){
        String sql = "SELECT max(id) as max_id from book";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            if(resultSet.next()){
                return resultSet.getInt("max_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return -1;
    }
    public void updateBook(Book book, int id) {
        String sql = "UPDATE book SET author = ?, title = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getAuthor());
            statement.setString(2, book.getTitle());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBookById(int id) {
        String sql = "DELETE FROM book WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
