package com.example.task;

import java.io.*;

public class FileUtility {
    private static final String CHARSET_NAME = "UTF-8";

    public static String read(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), CHARSET_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла", e);
        }
        return content.toString();
    }
}
