package org.danikzhezmer.dao;

import org.danikzhezmer.model.Book;

import java.sql.SQLException;

public class DAOTest {
    public static void main(String[] args) throws SQLException {
        BookDAO bookDAO = new BookDAO();
//       // Book daoBookById = bookDAO.getBookById(3);
//        //System.out.println(daoBookById);
//
//     //   System.out.println(bookDAO.getAll());
//
        Book book = new Book("12", "21");
        bookDAO.createBook(book);
//        System.out.println(bookDAO.getAll());
//
//        System.out.println(bookDAO.getBookById(8));

       // bookDAO.deleteBookById(10);
      //  System.out.println(bookDAO.getBookById(10));
      //  bookDAO.updateBook(book);
        System.out.println(bookDAO.getAll());


    }
}
