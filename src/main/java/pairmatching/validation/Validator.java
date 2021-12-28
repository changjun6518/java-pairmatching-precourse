package pairmatching.validation;

import pairmatching.constant.ErrorMessage;
import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.regex.Pattern;

public class Validator {
    public static final String YES = "네";
    public static final String NO = "아니오";
    public static final String QUIT = "Q";
    public static final Pattern VALID_USER_CHOICE_NUMBER = Pattern.compile("^[1-3]*$");

    public static final Integer COURSE = 0;
    public static final Integer LEVEL = 1;
    public static final Integer MISSION = 2;

    public static void isValidUserChoice(String userChoice) {
        if (isValidUserChoiceNumber(userChoice)) {
            return;
        }
        if (isValidUserChoiceQuitSign(userChoice)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.USER_CHOICE_ERROR_MESSAGE.getMessage());
    }

    public static void isValidCourseLevelMission(String courseLevelMission) {
        String[] splitCourseLevelMission = courseLevelMission.split(", ");
        if (splitCourseLevelMission.length != 3) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_FORM_ERROR_MESSAGE.getMessage());
        }
        if (!Course.has(splitCourseLevelMission[COURSE])) {
            throw new IllegalArgumentException(ErrorMessage.COURSE_ERROR_MESSAGE.getMessage());
        }
        if (!Level.has(splitCourseLevelMission[LEVEL])) {
            throw new IllegalArgumentException(ErrorMessage.LEVEL_ERROR_MESSAGE.getMessage());
        }
        Level level = Level.of(splitCourseLevelMission[LEVEL]);
        if (!level.hasMission(splitCourseLevelMission[MISSION])) {
            throw new IllegalArgumentException(ErrorMessage.MISSION_ERROR_MESSAGE.getMessage());
        }
    }

    public static void isValidRematchingChoice(String rematchingChoice) {
        if (rematchingChoice.equals(YES) || rematchingChoice.equals(NO)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.REMATCHING_CHOICE_ERROR_MESSAGE.getMessage());
    }

    private static boolean isValidUserChoiceNumber(String userChoice) {
        Pattern pattern = VALID_USER_CHOICE_NUMBER;
        return pattern.matcher(userChoice).matches();
    }

    private static boolean isValidUserChoiceQuitSign(String userChoice) {
        return userChoice.equals(QUIT);
    }
}
