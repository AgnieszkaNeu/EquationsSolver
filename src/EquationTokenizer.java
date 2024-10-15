import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EquationTokenizer {

    /*
        Transform equation to List
     */
    public static List <Object> getTokens(String equation) {
        HashMap <Character,Integer> operators = Operators.getOperators();
        equation = removeWhiteSpaces(equation);

        List<Object> characters = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        char currentChar;
        double value;

        for (int i = 0; i< equation.length(); i++) {

            currentChar = equation.charAt(i);

            //      When currentChar is a variable or char '='
            if (TypeChecker.isVariable(currentChar) || currentChar == '=') {
                characters.add(currentChar);
            }

            //      When first number is negative
            else if (currentChar == '-' &&  equation.charAt(i-1)== '='){
                number.setLength(0);
                while (TypeChecker.isInteger(equation.charAt(i+1))){
                    number.append(equation.charAt(i+1));
                    i +=1 ;
                }
                value = 0 - Double.valueOf(String.valueOf(number));
                characters.add(value);
            }

            //      When currentChar is an operator
            else if (operators.containsKey(currentChar)){
                characters.add(currentChar);
            }

            //      When currentChar is a number
            else if (TypeChecker.isInteger(currentChar)){
                number.setLength(0);
                number.append(currentChar);
                while (i+1<equation.length() && TypeChecker.isInteger(equation.charAt(i+1))){
                    number.append(equation.charAt(i+1));
                    i += 1;
                }
                characters.add(Double.valueOf(String.valueOf(number)));
            }

            else {
                throw new IllegalArgumentException("There is an incorrect character in the equation. Please check the correctness of the equation.");
            }
        }
        return characters;
    }

    private static String removeWhiteSpaces(String text){
        return text.strip().replace(" ", "").replace("\t", "");
    }
}
