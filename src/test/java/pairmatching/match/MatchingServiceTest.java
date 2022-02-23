package pairmatching.match;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.course.Course;
import pairmatching.level.Level;
import pairmatching.mission.Mission;
import pairmatching.view.OutputView;

class MatchingServiceTest {

    @Test
    public void matchTest() {
        // given
        Course course = Course.BACK_END;
        Level level = Level.LEVEL1;
        Matching matching = new Matching(course.getStringCrews());

        // when
        MatchingResult matchingResult = matching.match(level, course.getCrews());

        // then
        Assertions.assertTrue(matchingResult.isSuccessMatching());
    }

    @Test
    public void serviceMatchTest() throws Exception{
        // given
        Course course = Course.BACK_END;
        Level level = Level.LEVEL1;
        Mission mission = Mission.RACING_CAR;

        MatchingService matchingService = new MatchingService();
        // when
        MatchingResultDto matchingResultDto = matchingService.match(course, level, mission);

        // then
        OutputView.printMatchingResult(matchingResultDto);

    }

    @Test
    public void lookupMatchingResult() throws Exception{
        // given
        Course course = Course.BACK_END;
        Level level = Level.LEVEL1;
        Mission mission = Mission.RACING_CAR;

        MatchingService matchingService = new MatchingService();

        // when
        matchingService.match(course, level, mission);

        // then
        Assertions.assertDoesNotThrow(()->{
            matchingService.lookupMatchingResult(course, level, mission);
        });

    }
}