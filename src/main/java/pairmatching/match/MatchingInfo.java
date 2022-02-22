package pairmatching.match;

import pairmatching.course.Course;
import pairmatching.level.Level;
import pairmatching.mission.Mission;

import java.util.Objects;

public class MatchingInfo {
    private Course course;
    private Level level;
    private Mission mission;

    public MatchingInfo(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        MatchingInfo matchingInfo = (MatchingInfo) o;
        return course == matchingInfo.course &&
                level == matchingInfo.level && mission == matchingInfo.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
