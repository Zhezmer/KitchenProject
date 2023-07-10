package org.danikzhezmer;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class Loader {
    //todo в последнюю очередь сразу с буком реализовать
    private static final String FILE_NAME = "map.properties";

    public void saveToFile(Map<Integer, String> map) {

        //todo realize it
    }


    public Map<Integer, String> loadFromFile() {
        //todo realize it
        return Collections.EMPTY_MAP;
    }

    private File getFileOrCreateIfNotExists() throws IOException {
        String path = System.getProperty("user.home") + File.separator + FILE_NAME;
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

}
