package org.danikzhezmer;

public class Validator {

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

    private void validateCreate(String value) {
        String[] words = value.split(" ");
        if (words.length < 2) {
            wrongCommand("wrong size");
        }
        if (!"create".equals(words[0])) {
            wrongCommand("wrong command");
        }
        System.out.println("validateCreate");
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
        System.out.println("validateUpdate");
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
        System.out.println("validateDelete");
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
        System.out.println("validateGet");
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
