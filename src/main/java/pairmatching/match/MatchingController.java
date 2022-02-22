package pairmatching.match;

import pairmatching.course.Course;
import pairmatching.level.Level;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
    private MatchingService matchingService = new MatchingService();

    public void func() {
        String userChoice = InputView.getUserChoice();
        if (userChoice.equals("1")) {
            pairMatching();
        }
        // TODO - 상황에 있는거 기능 구현하면돼
    }

    public void pairMatching() {
        MatchingInfoDto matchingInfoDto = InputView.getRequiredMatchingInfo();

        MatchingResultDto matchingResultDto = matchingService.match(Level.of(matchingInfoDto.level), Course.of(matchingInfoDto.course));
        OutputView.printMatchingResult(matchingResultDto);
    }
}
