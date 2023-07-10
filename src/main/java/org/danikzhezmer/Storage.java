package org.danikzhezmer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {
    //todo заменить на мап<Integer book> (everywhere)
    private Map<Integer, String> map = new HashMap<>();
    private AtomicInteger id = new AtomicInteger(0);

    public Storage(Map<Integer, String> map) {
        this.map = map;
        Integer maxId = map.keySet().stream().max(Integer::compareTo).orElse(0);
        this.id = new AtomicInteger(maxId);
    }

    public Storage() {

    }

    public String get(int id) {

        return map.get(id);
    }

    public Map<Integer, String> getAll() {
        return map;
    }

    public Integer create(String value) {
        id.incrementAndGet();
        map.putIfAbsent(id.get(), value);
        return id.get();
    }

    public void update(int id, String value) {
        map.replace(id, value);
    }

    public void delete(int id) {
        map.remove(id);
    }
}
