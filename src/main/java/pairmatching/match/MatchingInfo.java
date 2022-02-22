package pairmatching.match;

import pairmatching.course.Course;
import pairmatching.level.Level;
import pairmatching.mission.Mission;

public class MatchingInfo {
    private Course course;
    private Level level;
    private Mission mission;

    public MatchingInfo(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

}
