import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String file = "C:\\Users\\agnne\\Desktop\\test.txt";
        List <String> equations = readFile(file);

        Calculator calculator = new Calculator();
        calculator.getResult(equations);
    }

    public static List <String> readFile (String file) throws IOException {
        List <String> lines = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e){
            System.out.println("Fail while loading file. Error: " + e);
        }
        return lines;
    }
}