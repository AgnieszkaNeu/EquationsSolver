import java.util.*;

public class ONP {

    /*
    ONP class transforms equation to stack according to the rules of ONP
    and allows to get result
     */

    HashMap<Character,Integer> operators;

    public ONP(){
        this.operators = Operators.getOperators();
    }

    public Deque<Object> listToONP(List<Object> characters){

        Deque<Object> output = new ArrayDeque<>();
        Deque<Object> stack = new ArrayDeque<>();

        Object lastOnStack;
        int value;
        int currentValue;

        for (Object character: characters){

            if (character instanceof Double){
                output.add(character);

            } else if (character.equals('(') || stack.isEmpty()) {
                stack.add(character);

            } else if (character.equals(')') ) {
                while (!(stack.peekLast().equals('('))){
                    lastOnStack = stack.pollLast();
                    output.add(lastOnStack);
                }
                stack.pollLast();

            } else {
                lastOnStack = stack.peekLast();
                value = this.operators.get((char) lastOnStack);
                currentValue = this.operators.get((char) character);

                if (currentValue<=value) {
                    stack.pollLast();
                    output.add(lastOnStack);
                }
                stack.add(character);
            }
        }
        while (!stack.isEmpty()){
            output.add(stack.pollLast());
        }

        return output;
    }

    public double calculate(Deque<Object> characters){

        Deque<Object> stack = new ArrayDeque<>();
        Object character;
        double x,y;

        while (!characters.isEmpty()){
            character = characters.pop();

            if (character instanceof Double){
                stack.add(character);
            }

            else {
                y = (double) stack.pollLast();
                x = (double) stack.pollLast();

                switch ( (char) character){

                    case '+':
                        stack.add(x+y);
                        break;

                    case '-':
                        stack.add(x-y);
                        break;

                    case '*':
                        stack.add(x*y);
                        break;

                    case '/':
                        stack.add(x/y);
                        break;

                    case '^':
                        stack.add(Math.pow(x,y));
                        break;
                }
            }
        }
        return (double) stack.pop();
    }
}
