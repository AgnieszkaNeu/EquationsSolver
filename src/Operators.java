import java.util.HashMap;

public class Operators {

    public static HashMap<Character,Integer> getOperators(){
        HashMap<Character,Integer> operators = new HashMap<>();

        operators.put('(',0);
        operators.put('+',1);
        operators.put('-',1);
        operators.put('*', 2);
        operators.put('/',2);
        operators.put('^',3);
        operators.put(')',3);

        return operators;
    }
}
