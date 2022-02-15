package pairmatching.crew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Crews {
    private final HashMap<String, Crew> crews = new HashMap<>();

    public Crews() {
    }

    public void add(String name) {
        crews.put(name, new Crew(name));
    }

    public List<String> returnStringList() {
        return new ArrayList<>(crews.keySet());
    }

}
