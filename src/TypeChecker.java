public class TypeChecker {

    public static boolean isInteger(char character){
        int value = Character.getNumericValue(character);
        return value > -1 && value < 10;
    }
    
    public static boolean isVariable(char character){
        if (character > 96 && character < 123){
            return true;
        } else if (character > 65 && character < 91) {
            return true;
        }
        return false;
    }

}
