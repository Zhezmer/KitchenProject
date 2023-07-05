package org.danikzhezmer;

import org.danikzhezmer.model.Command;
import org.danikzhezmer.model.CommandType;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Parser {
    Validator validator;

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
        command.setValue(Arrays.stream(args).skip(2).collect(Collectors.joining(" ")));
        return command;
    }

    //CREATE new value
    private Command parseCreate(String value) {
        String[] args = value.split(" ");
        Command command = new Command();
        command.setCommandType(CommandType.CREATE);
        command.setValue(Arrays.stream(args).skip(1).collect(Collectors.joining(" ")));
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


}

