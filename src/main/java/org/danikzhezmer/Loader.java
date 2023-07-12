package org.danikzhezmer;

import org.danikzhezmer.model.Book;

import java.io.*;
import java.util.Map;

public class Loader {
    private static final String FILE_NAME = "map.properties";
    String path = System.getProperty("user.home") + File.separator + FILE_NAME;

    public void saveToFile(Map<Integer, Book> map) {
        try {
            FileOutputStream fos = new FileOutputStream(getFileOrCreateIfNotExists());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.flush();
            oos.close();
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException("Saving is failed" + e.getMessage());
        }
    }


    public Map<Integer, Book> loadFromFile() {
        Map<Integer, Book> mapInFile;
        try {
            FileInputStream fis = new FileInputStream(getFileOrCreateIfNotExists());
            ObjectInputStream ois = new ObjectInputStream(fis);
            mapInFile = (Map<Integer, Book>) ois.readObject();
            ois.close();
            fis.close();
            for (Map.Entry<Integer, Book> m : mapInFile.entrySet()) {
                System.out.println(m.getKey() + " : " + m.getValue());
            }
        } catch (Exception e) {
            throw new RuntimeException("Loading is failed " + e.getMessage());
        }
        return mapInFile;
    }

    private File getFileOrCreateIfNotExists() throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

}

