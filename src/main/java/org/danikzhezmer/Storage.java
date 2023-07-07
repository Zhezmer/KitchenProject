package org.danikzhezmer;

import java.util.HashMap;
import java.util.List;

public class Storage {
    private HashMap<Integer, String> map = new HashMap<>();
    private int id = 0;

    public Storage(HashMap<Integer, String> map, int id) {
        this.map = map;
        this.id = id;
    }

    public Storage() {

    }
    public int idIncGet(int id){
        return this.id = id + 1;
    }

    public String get(int id) {
        return map.get(id);
    }

    public List<String> getAll() {
        return (List<String>) map.values();
    }

    public void create(String value) {
        map.putIfAbsent(idIncGet(id), value);
    }

    public void update(int id, String value) {
        map.replace(id, value);
    }

    public void delete(int id) {
        map.remove(id);
    }
}
