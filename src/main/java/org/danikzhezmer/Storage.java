package org.danikzhezmer;

import org.danikzhezmer.model.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {

    private Map<Integer, Book> map = new HashMap<>();
    private AtomicInteger id = new AtomicInteger(0);

    public Storage(Map<Integer, Book> map) {
        this.map = map;
        Integer maxId = map.keySet().stream().max(Integer::compareTo).orElse(0);
        this.id = new AtomicInteger(maxId);
    }
    public Book get(int id) {

        return map.get(id);
    }

    public Map<Integer, Book> getAll() {
        return map;
    }

    public Integer create(Book book) {
        id.incrementAndGet();
        map.putIfAbsent(id.get(), book);
        return id.get();
    }

    public void update(int id, Book book) {
        map.replace(id, book);
    }

    public void delete(int id) {
        map.remove(id);
    }
}
