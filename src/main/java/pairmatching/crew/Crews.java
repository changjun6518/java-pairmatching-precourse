package pairmatching.crew;

import java.util.HashMap;

public class Crews {
    private final HashMap<String, Crew> crews = new HashMap<>();

    public Crews() {
    }

    public void add(String name) {
        crews.put(name, new Crew(name));
    }
}
