import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EquationsSolver {
    public static void solve(String path) throws IOException {

        List<String> equations = readFile(path);

        Calculator calculator = new Calculator();
        HashMap<Character, Double> results;

        results = calculator.getResult(equations);

        if(results.isEmpty()){
            System.out.println("No solution.");
        }else {
            System.out.println(results);
        }
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
