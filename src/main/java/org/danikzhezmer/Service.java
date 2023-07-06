package org.danikzhezmer;

import org.danikzhezmer.model.Command;

/**
 * 4. убедится что все операции в хэшмап работают
 *
 *
 * 5. видосик про гит
 * 6. оформить все как мердж реквест
 * 7. скинуть ссылку на реквест
 */
public class Service {
    private Storage storage;

    public Service(Storage storage) {
        this.storage = storage;
    }

    public void execute(Command command){
        switch (command.getCommandType()){
            case GET -> executeGet(command);
            case GET_ALL -> executeGetAll(command);
            case CREATE -> executeCreate(command);
            case DELETE -> executeDelete(command);
            case UPDATE -> executeUpdate(command);
        }
    }

    private void executeGet(Command command){
        System.out.println(storage.get(command.getId()));

    }
    private void executeGetAll(Command command){
        System.out.println(storage.getAll());
    }
    private void executeUpdate(Command command){
        storage.update(command.getId(), command.getValue());
        System.out.println("updated");
    }
    private void executeDelete(Command command){
        storage.delete(command.getId());
        System.out.println("deleted");
    }
    private void executeCreate(Command command){
        storage.create(command.getValue());
        System.out.println("created");
    }

}
