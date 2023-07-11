package org.danikzhezmer.model;

public class Command {
    private CommandType commandType;
    private int id;
    private Book book;

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Command{" +
                "commandType=" + commandType +
                ", id=" + id +
                ", book=" + book +
                '}';
    }
}
