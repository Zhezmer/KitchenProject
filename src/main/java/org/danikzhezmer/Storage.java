package org.danikzhezmer;

import org.danikzhezmer.model.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {

    private final Map<Integer, Book> map;
    private final AtomicInteger id;

    public Storage(Map<Integer, Book> map) {
        this.map = new HashMap<>(map);
        Integer maxId = map.keySet().stream().max(Integer::compareTo).orElse(0);
        this.id = new AtomicInteger(maxId);
    }

    public Storage() {
        this.id = new AtomicInteger(0);
        this.map = new HashMap<>();
    }

    public Book get(int id) {

        return map.get(id);
    }

    public Map<Integer, Book> getAll() {
        return new HashMap<>(map);
    }

    public Integer create(Book book) {
        id.incrementAndGet();
        map.putIfAbsent(id.get(), book);
        return id.get();
    }

    public void update(int id, Book book) {
        map.replace(id, book);
        System.out.println("replaced");
    }

    public void delete(int id) {
        map.remove(id);
    }
}
