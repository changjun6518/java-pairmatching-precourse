package pairmatching.match;

import pairmatching.crew.Crews;
import pairmatching.level.Level;

import java.util.Collections;
import java.util.List;

public class Matching {

    private final List<String> stringCrews;

    public Matching(List<String> stringCrews) {
        this.stringCrews = stringCrews;
    }

    public MatchingResult match(Level level, Crews crews) {
        shuffle();
        MatchingResult matchingResult = new MatchingResult();
        matchingResult.match(stringCrews, level, crews);
        return matchingResult;
    }

    private void shuffle() {
        Collections.shuffle(stringCrews);
    }

}