package org.danikzhezmer;

import org.danikzhezmer.model.Book;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Loader {
    private static final String FILE_NAME = "map.properties";
    String path = System.getProperty("user.home") + File.separator + FILE_NAME;
    Properties properties = new Properties();

    public void saveToFile(Map<Integer, Book> map) {
        try ( FileOutputStream fos = new FileOutputStream(getFileOrCreateIfNotExists())) {
            properties.putAll(map);
            properties.store(fos, null);
        } catch (Exception e) {
            throw new RuntimeException("Saving is failed" + e.getMessage());
        }
    }


    public Map<Integer, Book> loadFromFile() {

        try (FileInputStream fis = new FileInputStream(getFileOrCreateIfNotExists())) {
            Map<Integer, Book> map = new HashMap<>();
            properties.load(fis);
            for (String key : properties.stringPropertyNames()) {
                map.put(Integer.parseInt(key), (Book) properties.get(key));
            }
            return map;
        } catch (Exception e) {
            throw new RuntimeException("Loading is failed " + e.getMessage());
        }

    }

    private File getFileOrCreateIfNotExists() throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

}

