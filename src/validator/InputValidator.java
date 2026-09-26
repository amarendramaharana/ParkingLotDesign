package validator;

public class InputValidator {
    private static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
    private static boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isNotValidInput(String value){
        return isNullOrBlank(value) && isNullOrEmpty(value);
    }

}
