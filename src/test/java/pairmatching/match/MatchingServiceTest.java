package pairmatching.match;

import org.junit.jupiter.api.Test;
import pairmatching.course.Course;
import pairmatching.level.Level;

class MatchingServiceTest {

    @Test
    public void matchTest() {
        // given
        Course course = Course.BACK_END;
        Level level = Level.LEVEL1;
        MatchingService matchingService = new MatchingService();

        // when
        matchingService.match(level, course);

        // then
//        Assertions.assertTrue();
    }
}