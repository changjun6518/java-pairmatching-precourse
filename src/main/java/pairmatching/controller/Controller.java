package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.CrewRepository;
import pairmatching.domain.Level;
import pairmatching.domain.Matching;
import pairmatching.validation.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import javax.swing.plaf.PanelUI;
import java.util.HashMap;
import java.util.List;

public class Controller {
    private CrewRepository crewRepository = new CrewRepository();
    private HashMap<String, Matching> matchingHistory = new HashMap<>();
    private boolean flag = true;

    public void run() {
        try {
            while (flag){
                executeFunction();
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void executeFunction() {
        String userChoice = InputView.getUserChoice();
        Validator.isValidUserChoice(userChoice);
        if (userChoice.equals("1")) {
            executeMatching();
        } else if (userChoice.equals("2")) {
            executeRefer();
        } else if (userChoice.equals("3")) {
            executeInitialize();
        } else if (userChoice.equals("Q")) {
            flag = false;
        }
    }

    private void executeMatching() {
        OutputView.printProcessLevelMission();
        String courseLevelMission = InputView.getCourseLevelMission();
        Validator.isValidCourseLevelMission(courseLevelMission);
        if (matchingHistory.containsKey(courseLevelMission)) {
            String rematchingChoice = InputView.getRematchingChoice();
            Validator.isValidRematchingChoice(rematchingChoice);
            if (rematchingChoice.equals("아니오")) {
                return;
            }
        }
        String[] split = courseLevelMission.split(", ");
        Course course = Course.of(split[0]);
        Level level = Level.of(split[1]);
        Matching matching = new Matching(course);
        List<String> matchCrewList = matching.match(level, crewRepository.getCrewListBy(course));
        OutputView.printMatchingResult(matchCrewList);
        matchingHistory.put(courseLevelMission, matching);
    }

    private void executeRefer() {
        OutputView.printProcessLevelMission();
        String courseLevelMission = InputView.getCourseLevelMission();
        Matching matching = matchingHistory.get(courseLevelMission);
        List<String> matchingCrewList = matching.getMatchingCrewList();
        OutputView.printMatchingResult(matchingCrewList);
    }

    private void executeInitialize() {
        crewRepository = new CrewRepository();
        matchingHistory = new HashMap<>();
        OutputView.printResetMessage();
    }

}
