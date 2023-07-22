package org.danikzhezmer;

import org.danikzhezmer.model.Book;
import org.danikzhezmer.model.Command;
import org.danikzhezmer.model.CommandType;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceTest {

    Book book1 = new Book("3 mus", "Duma");
    Book book2 = new Book("exodus", "God");

    @Test
   void executeGetTest(){



    }
    @Test
    void executeCreateTest(){
        Storage storage = new Storage();
        Service service = new Service(storage);
        Command command = new Command(CommandType.CREATE, book1);

        service.execute(command);
        Map<Integer, Book> result = storage.getAll();
        assertEquals(1, result.size());
        assertEquals(book1, storage.get(1));

    }
    @Test
    void executeUpdateTest(){
        Storage storage = new Storage(Map.of(1, book2));
        Command command = new Command(CommandType.UPDATE, 1, book1);
        Service service = new Service(storage);


        service.execute(command);
        Map<Integer, Book> result = storage.getAll();
        assertEquals(1, result.size());
        assertEquals(book1, result.get(1));
    }
    @Test
    void executeDeleteTest(){
        Storage storage = new Storage(Map.of(1, book1));
        Command command = new Command(CommandType.DELETE, 1);
        Service service = new Service(storage);


        service.execute(command);
        assertTrue(storage.getAll().isEmpty());
    }

}
