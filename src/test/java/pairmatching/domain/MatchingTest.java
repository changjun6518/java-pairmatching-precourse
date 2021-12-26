package pairmatching.domain;

import org.junit.jupiter.api.Test;
import pairmatching.util.CrewFileReader;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pairmatching.constant.SystemMessage.BACK_END_FILE_PATH;

class MatchingTest {

    @Test
    public void shuffle_test() throws Exception {
        // given
        Matching matching = new Matching(Course.BACK_END);
        // when
        List<String> shuffleList = matching.shuffleList();
        // then
        for (String s : shuffleList) {
            System.out.println(s);
        }
    }

    @Test
    public void after_match_test() throws Exception {
        // given
        Matching matching = new Matching(Course.BACK_END);
        // when
    }
}