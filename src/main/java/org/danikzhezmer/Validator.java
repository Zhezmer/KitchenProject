package org.danikzhezmer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.danikzhezmer.model.Book;

public class Validator {

   private final ObjectMapper objectMapper = new ObjectMapper();
    public void validate(String value) {
        String[] words = value.split(" ");
        switch (words[0]) {
            case "create" -> validateCreate(value);
            case "get" -> validateGet(value);
            case "update" -> validateUpdate(value);
            case "delete" -> validateDelete(value);
            default -> wrongCommand("wrong command");
        }
    }
    private void wrongCommand(String message) {
        throw new IllegalArgumentException(message);
    }

    // create {title: harry, author: rowling}
    private void validateCreate(String value) {
        String[] words = value.split(" ");
        if (words.length < 2) {
            wrongCommand("wrong size");
        }
        if (!"create".equals(words[0])) {
            wrongCommand("wrong command");
        }
        try {
            objectMapper.readValue(getBookString(value), Book.class);
        } catch (JsonProcessingException e) {
            wrongCommand("value is not book");
        }

    }

    //update 12 new String
    private void validateUpdate(String value) {
        String[] words = value.split(" ");
        if (words.length < 3) {
            wrongCommand("wrong size");
        }
        if (!"update".equals(words[0])) {
            wrongCommand("wrong command");
        }
        if (isNotInt(words[1])) {
            wrongCommand("id is not integer");
        }
        try {
            objectMapper.readValue(getBookString(value), Book.class);
        } catch (JsonProcessingException e) {
            wrongCommand("value is not book");
        }

    }

    private void validateDelete(String value) {
        String[] words = value.split(" ");
        if (words.length < 2) {
            wrongCommand("wrong size");
        }
        if (!"delete".equals(words[0])) {
            wrongCommand("wrong command");
        }
        if (isNotInt(words[1])) {
            wrongCommand("id is not integer");
        }

    }

    //два кейса, гет без индекса и с индексом
    private void validateGet(String value) {
        String[] words = value.split(" ");
        if (words.length > 2) {
            wrongCommand("wrong size");
        }
        if (!"get".equals(words[0])) {
            wrongCommand("wrong command");
        }

        if (words.length > 1 && isNotInt(words[1])) {
            wrongCommand("id is not integer");
        }

    }
    private String getBookString(String command) {
        return command.substring(command.indexOf('{'));
    }

    private boolean isNotInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
