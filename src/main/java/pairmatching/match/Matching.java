package pairmatching.match;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.course.Course;
import pairmatching.crew.Crews;

import java.util.List;

public class Matching {
    private final List<String> stringCrews;

    public Matching(List<String> stringCrews) {
        this.stringCrews = stringCrews;
    }

    public void shuffle() {
        Randoms.shuffle(stringCrews);
    }
}
