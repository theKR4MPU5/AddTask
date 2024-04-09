import java.io.*;

public class FileUtility {
    //Метод чтения текста из файла
    public static String read(String path){
        File file = new File(path);
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();

    }
    //Метод записи текста в файл
    public static  void write(String string,String path) {
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
