import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleSubstitutionCipher {
    //Сохранение таблицы замены
    private char[] substitutionTable;
    //Конструктор класса и реалиизация
    public SimpleSubstitutionCipher(String substitutionTableFile) {
        try {
            this.substitutionTable = readSubstitutionTable(substitutionTableFile);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения таблицы замены из файла", e);
        }
    }

    // Метод для чтения таблицы замены из файла
    private char[] readSubstitutionTable(String substitutionTableFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(substitutionTableFile))) {
            StringBuilder tableBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                tableBuilder.append(line);
            }
            return tableBuilder.toString().toCharArray();
        }
    }

    // Метод для шифрования текста
    public String encrypt(String plaintext) {
        StringBuilder ciphertextBuilder = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                int index = Character.toLowerCase(ch) - 'a';
                if (index >= 0 && index < 26) {
                    ciphertextBuilder.append(substitutionTable[index]);
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

