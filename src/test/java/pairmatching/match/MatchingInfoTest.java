package pairmatching.match;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.course.Course;
import pairmatching.level.Level;
import pairmatching.mission.Mission;

import static org.junit.jupiter.api.Assertions.*;

class MatchingInfoTest {

    @Test
    public void keyEqualsTest() throws Exception{
        // given
        Course course = Course.BACK_END;
        Level level = Level.LEVEL1;
        Mission mission = Mission.RACING_CAR;

        // when
        MatchingInfo matchingInfo = new MatchingInfo(course, level, mission);
        MatchingInfo matchingInfo2 = new MatchingInfo(course, level, mission);

        // then
//        assertSame(matchingInfo, matchingInfo2);
        Assertions.assertSame(matchingInfo, matchingInfo2);
        System.out.println(matchingInfo.equals(matchingInfo2));
    }

}