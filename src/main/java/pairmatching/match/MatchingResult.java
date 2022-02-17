package pairmatching.match;

import pairmatching.crew.Crews;
import pairmatching.level.Level;

import java.util.ArrayList;
import java.util.List;

public class MatchingResult {
    private List<List<String>> matchingResult = new ArrayList<>();

    public MatchingResult() {
    }

    public void add(List<String> pairList) {
        matchingResult.add(pairList);
    }

    public boolean isValidPairMatching(Level level, Crews crews) {
        for (List<String> strings : matchingResult) {
            if (!crews.isValidPairMatching(level, strings)) {
                return false;
            }
        }
        return true;
    }

    public void saveMatching(Level level, Crews crews) {
        for (List<String> matching : matchingResult) {
            crews.saveMatchingHistory(level, matching);
        }
    }
}
