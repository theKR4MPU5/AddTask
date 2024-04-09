import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя шифруемого файла:");
        String path = scan.nextLine();
        System.out.println("Введите имя файла с таблицей:");
        String pathTable = scan.nextLine();
        File file = new File(path);
        if(!file.isFile()){
            System.out.println("Путь введен некорректно!");
            return;
        }
        File fileTable = new File(pathTable);
        if(!fileTable.isFile()){
            System.out.println("Путь введен некорректно!");
            return;
        }
        // Создаем экземпляр шифра с использованием таблицы замены из файла
        SimpleSubstitutionCipher cipher = new SimpleSubstitutionCipher(pathTable);

        // Читаем текст из файла
        String plaintext = FileUtility.read(path);
        // Шифруем текст
        String encryptedText = cipher.encrypt(plaintext);
        System.out.println("Зашифрованный текст: " + encryptedText);
    }
}