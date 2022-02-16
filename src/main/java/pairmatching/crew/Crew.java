package pairmatching.crew;

import pairmatching.level.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Crew {
    private final String name;
    private final HashMap<Level, List<String>> crewsByLevel;

    public Crew(String name) {
        this.name = name;
        crewsByLevel = new HashMap<>();
        for (Level level : Level.values()) {
            crewsByLevel.put(level, new ArrayList<>());
        }
    }

    public boolean isMatched(Level level, String crewName) {
        List<String> matchedCrews = crewsByLevel.get(level);
        return matchedCrews.contains(crewName);
    }

    public void saveMatchCrew(Level level, String crewName) {
        List<String> matchedCrews = crewsByLevel.get(level);
        matchedCrews.add(crewName);
    }

    @Override
    public String toString() {
        return name;
    }
}
