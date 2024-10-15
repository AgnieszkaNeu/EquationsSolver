import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class Calculator {

    HashMap<Character,List<Object>> equationsMap;
    HashMap<Character, Double> results;

    public Calculator(){
        this.equationsMap = new HashMap<>();
        this.results = new HashMap<>();
    }

    public void getResult(List <String> equations){

        ONP onp = new ONP();
        double result;

        for (String equation: equations) {
            List<Object> characters = EquationTokenizer.getTokens(equation);
            getVariable(characters);
        }

        int x = equationsMap.size();

        while (!equationsMap.isEmpty() && x>=0 ){
            for (char variable: equationsMap.keySet()){
                if (isSolvable(equationsMap.get(variable))){
                    Deque<Object> listToONP = onp.listToONP(equationsMap.get(variable));
                    result = onp.calculate(listToONP);
                    results.put(variable,result);
                }
            }
            changeVariablesToValues();
            removeSolved();
            x -= 1;
        }

        if(results.isEmpty()){
            System.out.println("Brak rozwiązania.");
        }else {
            System.out.println(results);
        }
    }

    private void getVariable(List<Object> equation){

        if (!equation.get(1).equals('=') || !TypeChecker.isVariable((char) equation.get(0))){
            throw new IllegalArgumentException("Niepoprawny zapis działania.");
        }
        char variable = (char) equation.get(0);
        equation.remove(0);
        equation.remove(0);
        equationsMap.put(variable,equation);
    }

    private boolean isSolvable (List<Object> characters){
        for(Object character: characters){
            if (!(character instanceof Double)){
                if (TypeChecker.isVariable((char) character)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void changeVariablesToValues(){
        for (char variable: results.keySet()) {
            for (List<Object> equation : equationsMap.values()){
                equation.replaceAll(c -> {
                    if (c.equals(variable)){
                        return results.get(variable);
                    }
                    return c;
                });
            }
        }
    }

    private void removeSolved(){
        for (char variable: results.keySet()){
            equationsMap.remove(variable);
        }
    }
}
