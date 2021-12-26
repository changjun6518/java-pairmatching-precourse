package pairmatching.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
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

    @Test
    public void after_match_test() throws Exception {
        // given
        Matching matching = new Matching();
        // when
        matching.match(Level.LEVEL1);
        matching.match(Level.LEVEL1);
        matching.match(Level.LEVEL1);
        matching.match(Level.LEVEL1);
        matching.match(Level.LEVEL1);
        // then
        CrewRepository crewRepository = matching.getCrewRepository();
        List<Crew> backEndCrewList = crewRepository.getBackEndCrewList();
        Crew crew = backEndCrewList.get(1);
        System.out.println(crew.getName());
        HashMap<Level, List<Crew>> matchedCrew = crew.getMatchedCrew();
        List<Crew> crews = matchedCrew.get(Level.LEVEL1);
        for (Crew crew1 : crews) {
            System.out.println(crew1.getName());
        }
    }
}