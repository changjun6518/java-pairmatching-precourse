package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Crew {
    private String name;
    private HashMap<Level, List<Crew>> matchedCrew = new HashMap<>();

    public Crew(String name) {
        this.name = name;
        init();
    }

    private void init() {
        for (Level level : Level.values()) {
            matchedCrew.put(level, new ArrayList<>());
        }
    }

    public boolean isPossibleMatch(Level level, Crew crew) {
        return !matchedCrew.get(level).contains(crew);
    }


}
