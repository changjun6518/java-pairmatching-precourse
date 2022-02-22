package pairmatching.match;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.course.Course;
import pairmatching.level.Level;

import static org.junit.jupiter.api.Assertions.*;

class MatchingResultTest {

    @Test
    public void matchTest() throws Exception{
        // given
        Course course = Course.BACK_END;
        Level level = Level.LEVEL1;
        MatchingResult matchingResult = new MatchingResult();

        // when
        matchingResult.match(course.getStringCrews(), level, course.getCrews());

        // then
        Assertions.assertTrue(matchingResult.isSuccessMatching());

    }

}