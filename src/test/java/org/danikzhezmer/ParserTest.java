package org.danikzhezmer;

import org.danikzhezmer.model.Book;
import org.danikzhezmer.model.Command;
import org.danikzhezmer.model.CommandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParserTest {
    Validator validator = new Validator();
    Parser parser = new Parser(validator);
    Book book = new Book();
    String JSON_BOOK_TOSTRING = "{title:'Harry Potter', author:'J. K. Rowling'}";

    @Test
    void parseGetTest(){
       Command command = parser.parse("get 23");
       assertEquals(CommandType.GET, command.getCommandType());
       assertEquals(23 ,command.getId());
       assertNull(command.getBook());

    }
    @Test
    void parseCreateTest(){
        Command command = parser.parse("create {\"title\":\"Harry Potter\",\"author\":\"J. K. Rowling\"}");
        assertEquals(CommandType.CREATE, command.getCommandType());
        assertEquals(JSON_BOOK_TOSTRING ,command.getBook().toString());


  }
    @Test
    void parseUpdateTest(){
        Command command = parser.parse("update 23 {\"title\":\"Harry Potter\",\"author\":\"J. K. Rowling\"}");
        assertEquals(CommandType.UPDATE, command.getCommandType());
        assertEquals(23 ,command.getId());
        assertEquals(JSON_BOOK_TOSTRING, command.getBook().toString());

    }
    @Test
    void parseDeleteTest(){
        Command command = parser.parse("delete 23");
        assertEquals(CommandType.DELETE, command.getCommandType());
        assertEquals(23 ,command.getId());


    }
}
