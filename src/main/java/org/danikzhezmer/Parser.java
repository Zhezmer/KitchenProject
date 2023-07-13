package org.danikzhezmer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.danikzhezmer.model.Book;
import org.danikzhezmer.model.Command;
import org.danikzhezmer.model.CommandType;

public class Parser {


    Validator validator;
    ObjectMapper objectMapper = new ObjectMapper();

    public Parser(Validator validator) {
        this.validator = validator;
    }

    public Command parse(String command) {
        String[] words = command.split(" ");
        validator.validate(command);

        switch (words[0]) {
            case "get" -> {
                return parseGet(command);
            }
            case "update" -> {
                return parseUpdate(command);
            }
            case "create" -> {
                return parseCreate(command);
            }
            case "delete" -> {
                return parseDelete(command);
            }

            default -> throw new IllegalArgumentException("Wrong command");
        }

    }

    //GET 1
    private Command parseGet(String value) {
        String[] args = value.split(" ");
        Command command = new Command();
        if (args.length == 1) {
            command.setCommandType(CommandType.GET_ALL);
            return command;
        }
        command.setCommandType(CommandType.GET);
        command.setId(Integer.parseInt(args[1]));

        return command;
    }

    //UPDATE 24 new value
    private Command parseUpdate(String value) {
        String[] args = value.split(" ");
        Command command = new Command();
        command.setCommandType(CommandType.UPDATE);
        command.setId(Integer.parseInt(args[1]));
        Book book = parseBook(value);
        command.setBook(book);
        return command;
    }

    //CREATE new value
    private Command parseCreate(String value) {
       // String[] args = value.split(" ");
        Command command = new Command();
        command.setCommandType(CommandType.CREATE);
        Book book = parseBook(value);
        command.setBook(book);
        return command;
    }

    //DELETE 2
    private Command parseDelete(String value) {
        String[] args = value.split(" ");
        Command command = new Command();
        command.setCommandType(CommandType.DELETE);
        command.setId(Integer.parseInt(args[1]));
        return command;
    }
    private Book parseBook(String command) {
        try {
            return objectMapper.readValue(getBookString(command), Book.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("wrong command");
        }
    }

    private String getBookString(String command) {
        return command.substring(command.indexOf('{'));
    }


}

