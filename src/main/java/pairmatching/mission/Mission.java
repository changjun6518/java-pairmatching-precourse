package pairmatching.mission;

import pairmatching.course.Course;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Mission {
    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL_GAME("숫자야구게임"),
    BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    PERFORMANCE("성능개선"),
    DISTRIBUTE("배포");


    private String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission of(String name) {
        return Arrays.stream(Mission.values()).
                filter(mission -> mission.isSameName(name))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private boolean isSameName(String name) {
        return this.name.equals(name);
    }
}
