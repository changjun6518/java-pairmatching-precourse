package pairmatching.match;

import jdk.nashorn.internal.objects.annotations.Getter;

public class MatchingInfoDto {
    public String course;
    public String level;
    public String mission;

    public MatchingInfoDto(String course, String level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }
}
