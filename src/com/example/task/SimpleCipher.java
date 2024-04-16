package com.example.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleCipher {
    private static final int ALPHABET_SIZE = 26;
    private final char[] table;

    public SimpleCipher(String tableFile) {
        try {
            this.table = this.readTable(tableFile);
            if (this.table.length != ALPHABET_SIZE) {
                throw new IllegalArgumentException("Таблица замены должна содержать 26 символов");
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения таблицы замены из файла", e);
        }
    }

    private char[] readTable(String tableFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(tableFile))) {
            StringBuilder tableBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                tableBuilder.append(line);
            }
            return tableBuilder.toString().toCharArray();
        }
    }

    public String encrypt(String plaintext) {
        StringBuilder ciphertextBuilder = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                int index = Character.toLowerCase(ch) - 'a';
                if (index >= 0 && index < ALPHABET_SIZE) {
                    ciphertextBuilder.append(this.table[index]);
                } else {
                    ciphertextBuilder.append(ch);
                }
            } else {
                ciphertextBuilder.append(ch);
            }
        }
        return ciphertextBuilder.toString();
    }
}
