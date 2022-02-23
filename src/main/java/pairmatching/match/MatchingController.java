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
            } else if (userChoice.equals("2")) {
                lookupMatching();
            }
        }
        // TODO - 조회 기능 , 초기화 기능 추가, 예외처리 확실하게!
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

    public void lookupMatching() {
        MatchingInfoDto matchingInfoDto = InputView.getRequiredMatchingInfo();
        Course course = Course.of(matchingInfoDto.course);
        Level level = Level.of(matchingInfoDto.level);
        Mission mission = Mission.of(matchingInfoDto.mission);
        MatchingResultDto matchingResultDto = matchingService.lookupMatchingResult(course, level, mission);
        OutputView.printMatchingResult(matchingResultDto);
    }
}
