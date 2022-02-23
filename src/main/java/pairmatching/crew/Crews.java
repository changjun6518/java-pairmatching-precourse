package pairmatching.crew;

import pairmatching.level.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static pairmatching.match.MatchingResult.PAIR_SIZE;

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

    public Boolean isValidPairMatching(Level level, List<String> matchingResult) {
        if (matchingResult.size() == PAIR_SIZE) {
            Crew firstCrew = crews.get(matchingResult.get(0));
            return !firstCrew.isMatched(level, matchingResult.get(PAIR_SIZE - 1));
        }
        return isValidPairMatching(level, matchingResult.subList(0, PAIR_SIZE))
                && isValidPairMatching(level, matchingResult.subList(PAIR_SIZE - 1, PAIR_SIZE + 1))
                && isValidPairMatching(level, Arrays.asList(matchingResult.get(0), matchingResult.get(PAIR_SIZE)));
    }

    public void saveMatchingHistory(Level level, List<String> matchingResult) {
        if (matchingResult.size() == PAIR_SIZE) {
            Crew firstCrew = crews.get(matchingResult.get(0));
            Crew secondCrew = crews.get(matchingResult.get(PAIR_SIZE - 1));

            firstCrew.saveMatchCrew(level, secondCrew.toString());
            secondCrew.saveMatchCrew(level, firstCrew.toString());
            return;
        }
        Crew firstCrew = crews.get(matchingResult.get(0));
        Crew secondCrew = crews.get(matchingResult.get(PAIR_SIZE - 1));
        Crew thirdCrew = crews.get(matchingResult.get(PAIR_SIZE));

        firstCrew.saveMatchCrew(level, secondCrew.toString());
        firstCrew.saveMatchCrew(level, thirdCrew.toString());
        secondCrew.saveMatchCrew(level, firstCrew.toString());
        secondCrew.saveMatchCrew(level, thirdCrew.toString());
        thirdCrew.saveMatchCrew(level, firstCrew.toString());
        thirdCrew.saveMatchCrew(level, secondCrew.toString());
    }

    public void deleteAll() {
        for (String name : crews.keySet()) {
            Crew crew = crews.get(name);
            crew.deleteAll();
        }
    }
}
