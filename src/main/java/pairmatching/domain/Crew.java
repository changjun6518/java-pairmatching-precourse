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

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public void putMatchedCrew(Level level, Crew crew) {
        List<Crew> crewList = matchedCrew.get(level);
        crewList.add(crew);
        matchedCrew.put(level, crewList);
    }

    public HashMap<Level, List<Crew>> getMatchedCrew() {
        return matchedCrew;
    }

    public String getName() {
        return name;
    }
}
