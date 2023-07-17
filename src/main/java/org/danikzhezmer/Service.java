package org.danikzhezmer;

import org.danikzhezmer.model.Command;
public class Service {
    private final Storage storage;

    public Service(Storage storage) {
        this.storage = storage;
    }

    public void execute(Command command){
        switch (command.getCommandType()){
            case GET -> executeGet(command);
            case GET_ALL -> executeGetAll();
            case CREATE -> executeCreate(command);
            case DELETE -> executeDelete(command);
            case UPDATE -> executeUpdate(command);
        }
    }

    private void executeGet(Command command){
        System.out.println(storage.get(command.getId()));

    }
    private void executeGetAll(){
        System.out.println(storage.getAll().values().stream().toList());
    }
    private void executeUpdate(Command command){
        storage.update(command.getId(), command.getBook());
        System.out.printf("Book with id = {%d} updated\n", command.getId());
    }
    private void executeDelete(Command command){

        storage.delete(command.getId());
        System.out.println("Book deleted");
    }
    private void executeCreate(Command command){
        Integer id = storage.create(command.getBook());
        System.out.printf("Book saved with id = {%s}\n", id);
    }

}
