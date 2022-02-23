package pairmatching.match;

import pairmatching.crew.Crews;
import pairmatching.level.Level;

import java.util.ArrayList;
import java.util.List;

public class MatchingResult {
    public static final int PAIR_SIZE = 2;
    private static final int ODD_NUMBER_GAP = 3;
    private List<List<String>> matchingResult = new ArrayList<>();

    public MatchingResult() {
    }

    public void match(List<String> stringCrews, Level level, Crews crews) {
        combine(stringCrews);
        if (isValidPairMatching(level, crews)) {
            saveMatching(level, crews);
        }
    }

    private void combine(List<String> stringCrews) {
        if (stringCrews.size() % 2 == 0) {
            for (int i = 0; i < stringCrews.size(); i += PAIR_SIZE) {
                matchingResult.add(stringCrews.subList(i, i + PAIR_SIZE));
            }
            return;
        }
        for (int i = 0; i < stringCrews.size() - ODD_NUMBER_GAP; i += PAIR_SIZE) {
            matchingResult.add(stringCrews.subList(i, i + PAIR_SIZE));
        }
        matchingResult.add(stringCrews.subList(stringCrews.size() - 3, stringCrews.size()));
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

    public boolean isFailedMatching() {
        return matchingResult.isEmpty();
    }

    public boolean isSuccessMatching() {
        return !matchingResult.isEmpty();
    }

    public MatchingResultDto convertDto() {
        return new MatchingResultDto(matchingResult);
    }
}
