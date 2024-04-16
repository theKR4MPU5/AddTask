package com.example.task;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static final String RESOURCES_PATH = "src\\resources\\";

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Введите имя шифруемого файла (из папки resources):");
            String path = RESOURCES_PATH + scan.nextLine();
            System.out.println("Введите имя файла с таблицей (из папки resources):");
            String pathTable = RESOURCES_PATH + scan.nextLine();
            File file = new File(path);
            if (!file.isFile() || !file.exists()) {
                System.out.println("Шифруемый файл не существует или не является файлом! - " + path);
                return;
            }

            File fileTable = new File(pathTable);
            if (!fileTable.isFile() || !fileTable.exists()) {
                System.out.println("Файл с таблицей замены не существует или не является файлом! - " + pathTable);
                return;
            }

            SimpleCipher cipher = new SimpleCipher(pathTable);
            String plaintext = FileUtility.read(path);
            String encryptedText = cipher.encrypt(plaintext);

            //System.out.println("Зашифрованный текст: " + encryptedText);

            // Запись зашифрованного текста в файл result.txt
            String resultFilePath = RESOURCES_PATH + "result.txt";
            try {
                Files.write(Paths.get(resultFilePath), encryptedText.getBytes());
                System.out.println("Результат успешно записан в файл: " + resultFilePath);
            } catch (IOException e) {
                System.err.println("Ошибка записи результата в файл: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
