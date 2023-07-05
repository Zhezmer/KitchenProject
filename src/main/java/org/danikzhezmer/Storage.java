package org.danikzhezmer;

import java.util.HashMap;
import java.util.List;

public class Storage {
    private HashMap<Integer, String> map;
    private int id = 0;


    public String get(int id) {
        return map.get(id);
    }

   public List<String> getAll() {
        return (List<String>) map.values();
    }
    public void create(String value){
        this.id++;
        map.putIfAbsent(this.id, value);
    }

   public void update(int id, String value){
       map.replace(id, value);
   }

   public void delete(int id){
        map.remove(id);
   }
}
