package pairmatching;

import pairmatching.domain.*;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class MatchingApplication {
    private CrewRepository crewRepository = new CrewRepository();

    public void run() {
        String userChoice = InputView.getUserChoice();
        if (userChoice.equals("1")) {
            OutputView.printProcessLevelMission();
            String courseLevelMission = InputView.getCourseLevelMission();
            String[] split = courseLevelMission.split(", ");
            Course course = Course.of(split[0]);
            Level level = Level.of(split[1]);
            Matching matching = new Matching(course);
            matching.match(level, crewRepository.getCrewListBy(course));
        } else if (userChoice.equals("2")) {

        } else if (userChoice.equals("3")) {

        } else if (userChoice.equals("Q")) {

        }
    }
}
