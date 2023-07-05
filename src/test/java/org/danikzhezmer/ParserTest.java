package org.danikzhezmer;

import org.danikzhezmer.model.Command;
import org.danikzhezmer.model.CommandType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParserTest {
    Validator validator = new Validator();
    Parser parser = new Parser(validator);
    @Test
    void parseGetTest(){
       Command command = parser.parse("get 23");
       assertEquals(CommandType.GET, command.getCommandType());
       assertEquals(23 ,command.getId());
       assertNull(command.getValue());

    }
    @Test
    void parseCreateTest(){
        Command command = parser.parse("create dog fish");
        assertEquals(CommandType.CREATE, command.getCommandType());
        assertEquals("dog fish" ,command.getValue());


  }
    @Test
    void parseUpdateTest(){
        Command command = parser.parse("update 23 dog jellyfish");
        assertEquals(CommandType.UPDATE, command.getCommandType());
        assertEquals(23 ,command.getId());
        assertEquals("dog jellyfish", command.getValue());

    }
    @Test
    void parseDeleteTest(){
        Command command = parser.parse("delete 23");
        assertEquals(CommandType.DELETE, command.getCommandType());
        assertEquals(23 ,command.getId());


    }
}
