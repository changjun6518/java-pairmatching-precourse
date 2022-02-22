package pairmatching.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MatchingRepository {
    // 페어 매칭을 보관하는 역할
    private final List<Matching> matchings = new ArrayList<>();
//    private final HashMap<MatchingInfo, >
    
    // TODO 생각하고 행동해 손으로 천천히 그려보면서 어떻게 할지 생각해보자
    // TODO Key 값에 따라서 결과가 저장되어야 하는데 Dto 보다는 다른 걸 해야하는데 service에서 받아오려면 로직 수정해야함

    public MatchingRepository() {
    }

    public void add(Matching matching) {
        matchings.add(matching);
    }
}
