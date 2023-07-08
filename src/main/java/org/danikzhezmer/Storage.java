package org.danikzhezmer;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Storage {
    private HashMap<Integer, String> map = new HashMap<>();
    private AtomicInteger id = new AtomicInteger(0);

    public Storage(HashMap<Integer, String> map, AtomicInteger id) {
        this.map = map;
        this.id = id;
    }

    public Storage() {

    }

    public String get(int id) {

        return map.get(id);
    }

    public List<String> getAll() {
        return  map.values().stream().toList();
    }

    public void create(String value) {
        id.incrementAndGet();
        map.putIfAbsent(id.get(), value);
    }

    public void update(int id, String value) {
        map.replace(id, value);
    }

    public void delete(int id) {
        if (id > map.size()){
            System.out.println("deleting impossible");
            return;
        }else map.remove(id);
    }
}
