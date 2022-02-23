package pairmatching.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MatchingRepository {
    // 페어 매칭을 보관하는 역할
    private final HashMap<MatchingInfo, MatchingResult> repository = new HashMap<>();

    public MatchingRepository() {
    }

    public void put(MatchingInfo matchingInfo, MatchingResult matchingResult) {
        repository.put(matchingInfo, matchingResult);
    }

    public boolean contains(MatchingInfo matchingInfo) {
        return repository.containsKey(matchingInfo);
    }

    public MatchingResult get(MatchingInfo matchingInfo) {
        return repository.get(matchingInfo);
    }

    public void deleteAll() {
        repository.clear();

    }
}
