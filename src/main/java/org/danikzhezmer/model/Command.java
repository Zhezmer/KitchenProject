package org.danikzhezmer.model;

public class Command {
    private CommandType commandType;
    private int id;
    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Command{" +
                "commandType=" + commandType +
                ", id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
