package pairmatching.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Course {
    BACK_END("백엔드"),
    FRONT_END("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static String print() {
        return "과정: " + Arrays.stream(Course.values())
                .map(course -> course.name)
                .collect(Collectors.joining(" | "));
    }
}