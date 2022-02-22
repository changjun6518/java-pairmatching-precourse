package pairmatching.match;

import pairmatching.course.Course;
import pairmatching.level.Level;
import pairmatching.mission.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
    private MatchingService matchingService = new MatchingService();

    public void func() {
        while (true) {

            String userChoice = InputView.getUserChoice();
            if (userChoice.equals("1")) {
                pairMatching();
            }
        }
        // TODO - 상황에 있는거 기능 구현하면돼
    }

    public void pairMatching() {
        MatchingInfoDto matchingInfoDto = InputView.getRequiredMatchingInfo();
        Course course = Course.of(matchingInfoDto.course);
        Level level = Level.of(matchingInfoDto.level);
        Mission mission = Mission.of(matchingInfoDto.mission);
        boolean flag = true;
        if (matchingService.isExist(course, level, mission)) {
            flag = InputView.getReMatching();
        }
        if (flag) {
            MatchingResultDto matchingResultDto = matchingService.match(course, level, mission);
            OutputView.printMatchingResult(matchingResultDto);
        }
    }
}
