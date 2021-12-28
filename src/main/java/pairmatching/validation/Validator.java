package pairmatching.validation;

import java.util.regex.Pattern;

public class Validator {
    public static boolean isValidUserChoice(String userChoice) {
        if (isValidUserChoiceNumber(userChoice)) {
            return true;
        }
        if (isValidUserChoiceQuitSign(userChoice)) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 1,2,3,Q 중 하나를 입력하시오");
    }

    private static boolean isValidUserChoiceNumber(String userChoice) {
        Pattern pattern = Pattern.compile("^[1-3]*$");
        return pattern.matcher(userChoice).matches();
    }

    private static boolean isValidUserChoiceQuitSign(String userChoice) {
        return userChoice.equals("Q");
    }
}
