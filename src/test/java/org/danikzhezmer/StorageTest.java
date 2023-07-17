package org.danikzhezmer;

import org.danikzhezmer.model.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.HashMap;
import java.util.Map;

public class StorageTest {

        Book book1 = new Book("3 mus", "Duma");
        Book book2 = new Book("exodus", "God");
        Map<Integer, Book> map = Map.of(1, book1, 2, book2);


    @Test
    void getTest(){
        Storage storage = new Storage(map);
        assertEquals(book1, storage.get(1));
    }

    @Test
    void createTest(){
        Map<Integer, Book> newMap = new HashMap<>();
        Storage storage = new Storage(newMap);
        storage.create(book1);
        assertEquals(1, newMap.size());
        assertEquals(book1, newMap.get(1));


    }
    @Test
    void updateTest(){
        Map<Integer, Book> newMap = Map.of(1, book1);
        Storage storage = new Storage(newMap);

        storage.update(1, book2);
        assertEquals(1, map.size());
        assertEquals(book2, map.get(1));
    }
    @Test
    void deleteTest(){
        Map<Integer, Book> newMap = Map.of(1, book1);
        Storage storage = new Storage(newMap);
        storage.delete(1);
        assertEquals(null, storage.get(1));

    }


}
