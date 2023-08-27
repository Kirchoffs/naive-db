package org.syh.demo.db.naive;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileHandlerTest {
    @Test
    public void test() {
        String path = "src/test/resources/file-handler-test/naive-db-data";
        new File(path).delete();

        try {
            FileHandler fileHandler = new FileHandler(path);
            fileHandler.add("Ben", 29, "San Jose", "3F3F3F3F", "Someone");
            fileHandler.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new File(path).delete();
    }
}
