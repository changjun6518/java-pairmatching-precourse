package pairmatching.match;

import pairmatching.crew.Crews;
import pairmatching.level.Level;

import java.util.Collections;
import java.util.List;

public class Matching {
    public static final int PAIR_SIZE = 2;
    private static final int ODD_NUMBER_GAP = 3;

    private final List<String> stringCrews;
    private final MatchingResult matchingResult;

    public Matching(List<String> stringCrews) {
        this.stringCrews = stringCrews;
        matchingResult = new MatchingResult();
    }

    public boolean match(Level level, Crews crews) {
        shuffle();
        combine();
        if (matchingResult.isValidPairMatching(level, crews)) {
            matchingResult.saveMatching(level, crews);
            return true;
        }
        return false;
    }

    private void shuffle() {
        Collections.shuffle(stringCrews);
    }

    private boolean isEven() {
        return stringCrews.size() % 2 == 0;
    }

    private void combine() {
        if (isEven()) {
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

}