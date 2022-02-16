package pairmatching.match;

import org.junit.jupiter.api.Test;
import pairmatching.course.Course;

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

}