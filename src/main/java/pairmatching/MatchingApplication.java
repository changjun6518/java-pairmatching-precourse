package pairmatching;

import pairmatching.domain.*;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class MatchingApplication {
    private CrewRepository crewRepository = new CrewRepository();
    private HashMap<String, Matching> matchingHistory = new HashMap<>();

    public void run() {
        while (true) {
            String userChoice = InputView.getUserChoice();
            if (userChoice.equals("1")) {
                OutputView.printProcessLevelMission();
                String courseLevelMission = InputView.getCourseLevelMission();
                if (matchingHistory.containsKey(courseLevelMission)) {
                    String rematchingChoice = InputView.getRematchingChoice();
                    if (rematchingChoice.equals("아니오")) {
                        continue;
                    }
                }
                String[] split = courseLevelMission.split(", ");
                Course course = Course.of(split[0]);
                Level level = Level.of(split[1]);
                Matching matching = new Matching(course);
                List<String> matchCrewList = matching.match(level, crewRepository.getCrewListBy(course));
                OutputView.printMatchingResult(matchCrewList);
                matchingHistory.put(courseLevelMission, matching);
            } else if (userChoice.equals("2")) {
                OutputView.printProcessLevelMission();
                String courseLevelMission = InputView.getCourseLevelMission();
                Matching matching = matchingHistory.get(courseLevelMission);
                List<String> matchingCrewList = matching.getMatchingCrewList();
                OutputView.printMatchingResult(matchingCrewList);
            } else if (userChoice.equals("3")) {
                crewRepository = new CrewRepository();
                matchingHistory = new HashMap<>();
            } else if (userChoice.equals("Q")) {
                break;
            }
        }
    }
}
