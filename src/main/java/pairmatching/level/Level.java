package pairmatching.level;

import pairmatching.mission.Mission;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(Mission.RACING_CAR, Mission.LOTTO, Mission.BASEBALL_GAME)),
    LEVEL2("레벨2", Arrays.asList(Mission.BASKET, Mission.PAYMENT, Mission.SUBWAY)),
    LEVEL3("레벨3"),
    LEVEL4("레벨4", Arrays.asList(Mission.PERFORMANCE, Mission.DISTRIBUTE)),
    LEVEL5("레벨5"),
    ;

    private String name;
    private List<Mission> missions;

    Level(String name) {
        this.name = name;
    }

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level of(String name) {
        return Arrays.stream(Level.values())
                .filter(level -> level.isSameLevel(name))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

    }

    public boolean isSameLevel(String name) {
        return this.name.equals(name);
    }
}
