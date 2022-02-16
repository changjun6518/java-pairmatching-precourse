package pairmatching.match;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Matching {
    private static final int PAIR_SIZE = 2;
    private static final int ODD_NUMBER_GAP = 3;

    private final List<String> stringCrews;
    private final List<List<String>> matchingResult;

    public Matching(List<String> stringCrews) {
        this.stringCrews = stringCrews;
        matchingResult = new ArrayList<>();
    }

    public void shuffle() {
        Randoms.shuffle(stringCrews);
    }

    private boolean isEven() {
        return stringCrews.size() % 2 == 0;
    }

    public void match() {
        if (isEven()) {
            for (int i = 0; i < stringCrews.size(); i += PAIR_SIZE) {
                matchingResult.add(stringCrews.subList(i, i + PAIR_SIZE));
            }
        } else {
            for (int i = 0; i < stringCrews.size() - ODD_NUMBER_GAP; i += PAIR_SIZE) {
                matchingResult.add(stringCrews.subList(i, i + PAIR_SIZE));
            }
            matchingResult.add(stringCrews.subList(stringCrews.size() - 3, stringCrews.size()));
        }
    }

    public void printMatchingResult() {
        for (List<String> strings : matchingResult) {
            System.out.println(String.join(", ", strings));
        }
    }

}
