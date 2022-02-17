package pairmatching.match;

import java.util.ArrayList;
import java.util.List;

public class MatchingRepository {
    // 페어 매칭을 보관하는 역할
    private final List<Matching> matchings = new ArrayList<>();

    public MatchingRepository() {
    }

    public void add(Matching matching) {
        matchings.add(matching);
    }
}
