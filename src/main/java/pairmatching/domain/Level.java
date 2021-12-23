package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;
    private List<String> missions = new ArrayList<>();

    Level(String name) {
        this.name = name;
    }

    public void setMissions(List<String> missions) {
        this.missions = missions;
    }

    public String printMissions() {
        if (missions.isEmpty()) {
            return "  - " + name + ": ";
        }
        return "  - " + name + ": " + String.join(" | ", missions);
    }
}
