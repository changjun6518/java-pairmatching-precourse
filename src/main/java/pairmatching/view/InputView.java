package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static pairmatching.util.constant.InputViewMessage.ASK_COURSE_LEVEL_MISSION;
import static pairmatching.util.constant.InputViewMessage.ASK_USER_CHOICE_MESSAGE;

public class InputView {
    public static String getUserChoice() {
        System.out.println(ASK_USER_CHOICE_MESSAGE);
        return readLine();
    }

    public static String getCourseLevelMission() {
        System.out.println(ASK_COURSE_LEVEL_MISSION);
        return readLine();
    }
}
