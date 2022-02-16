package pairmatching.match;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.course.Course;
import pairmatching.level.Level;

class MatchingTest {
    @Test
    public void matchingTest() {
        // given
        Course course = Course.BACK_END;
        Matching matching = new Matching(course.getStringCrews());

        // when
        matching.shuffle();
        matching.match();

        // then
        matching.printMatchingResult();
    }

    @Test
    public void validPairMatching() throws Exception{
        // given
        Level level = Level.LEVEL1;
        Course course = Course.BACK_END;
        Matching matching = new Matching(course.getStringCrews());

        // when
        matching.shuffle();
        matching.match();

        // then
        Assertions.assertTrue(matching.isValidPairMatching(level, course.getCrews()));
    }

    @Test
    public void checkSaveMatchingHistory() throws Exception {
        // given
        Level level = Level.LEVEL1;
        Course course = Course.BACK_END;
        Matching matching = new Matching(course.getStringCrews());

        // when
        matching.shuffle();
        matching.match();
        matching.saveMatching(level, course.getCrews());

        // then
        matching.match();
        Assertions.assertFalse(matching.isValidPairMatching(level, course.getCrews()));
    }
}