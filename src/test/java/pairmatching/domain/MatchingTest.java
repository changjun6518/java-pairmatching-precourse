package pairmatching.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchingTest {

    @Test
    public void shuffle_test() throws Exception {
        // given
        Matching matching = new Matching();
        // when
        List<String> shuffleList = matching.shuffleList();
        // then
        for (String s : shuffleList) {
            System.out.println(s);
        }
    }
}