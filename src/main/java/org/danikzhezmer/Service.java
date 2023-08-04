package org.danikzhezmer;

import org.danikzhezmer.dao.BookDAO;
import org.danikzhezmer.model.Command;

import java.sql.SQLException;

public class Service {
    private final BookDAO bookDAO;

    public Service(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void execute(Command command) throws SQLException {
        switch (command.getCommandType()){
            case GET -> executeGet(command);
            case GET_ALL -> executeGetAll();
            case CREATE -> executeCreate(command);
            case DELETE -> executeDelete(command);
            case UPDATE -> executeUpdate(command);
        }
    }

    private void executeGet(Command command){

        System.out.println(bookDAO.getBookById(command.getId()));

    }
    private void executeGetAll() throws SQLException {
        System.out.println(bookDAO.getAll().values().stream().toList());
    }
    private void executeUpdate(Command command){
        bookDAO.updateBook(command.getBook());
        System.out.printf("Book with id = {%d} updated\n", command.getId());
    }
    private void executeDelete(Command command){

        bookDAO.deleteBookById(command.getId());
        System.out.println("Book deleted");
    }
    private void executeCreate(Command command){
        bookDAO.createBook(command.getBook());
        System.out.printf("Book saved with id = {%s}\n", command.getId());
    }

}
