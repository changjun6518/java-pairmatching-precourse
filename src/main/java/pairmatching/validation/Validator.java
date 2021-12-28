package pairmatching.validation;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.regex.Pattern;

public class Validator {
    public static void isValidUserChoice(String userChoice) {
        if (isValidUserChoiceNumber(userChoice)) {
            return;
        }
        if (isValidUserChoiceQuitSign(userChoice)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 1,2,3,Q 중 하나를 입력하시오");
    }

    public static void isValidCourseLevelMission(String courseLevelMission) {
        String[] splitCourseLevelMission = courseLevelMission.split(", ");
        if (splitCourseLevelMission.length != 3) {
            throw new IllegalArgumentException("[ERROR] 과정, 레벨, 미션을 입력하시오");
        }
        if (!Course.has(splitCourseLevelMission[0])) {
            throw new IllegalArgumentException("[ERROR] 해당 과정이 없습니다");
        }
        if (!Level.has(splitCourseLevelMission[1])) {
            throw new IllegalArgumentException("[ERROR] 해당 레벨이 없습니다");
        }
        Level level = Level.of(splitCourseLevelMission[1]);
        if (!level.hasMission(splitCourseLevelMission[2])) {
            throw new IllegalArgumentException("[ERROR] 해당 미션이 없습니다");
        }
    }

    public static void isValidRematchingChoice(String rematchingChoice) {
        if (rematchingChoice.equals("네") || rematchingChoice.equals("아니오")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 네 또는 아니오로 대답하시오");
    }

    private static boolean isValidUserChoiceNumber(String userChoice) {
        Pattern pattern = Pattern.compile("^[1-3]*$");
        return pattern.matcher(userChoice).matches();
    }

    private static boolean isValidUserChoiceQuitSign(String userChoice) {
        return userChoice.equals("Q");
    }
}
