package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.util.CrewFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.constant.SystemMessage.BACK_END_FILE_PATH;
import static pairmatching.constant.SystemMessage.FRONT_END_FILE_PATH;

public class Matching {
    private List<String> matchingCrewList;

    public Matching(Course course) {
        setMatchingCrewList(course);
    }

    private void setMatchingCrewList(Course course) {
        if (course == Course.BACK_END) {
            matchingCrewList = CrewFileReader.readCrewList(BACK_END_FILE_PATH);
            return;
        }
        matchingCrewList = CrewFileReader.readCrewList(FRONT_END_FILE_PATH);

    }

    public List<String> match(Level level, List<Crew> crewList) {
        int count = 0;
        while (count < 3) {
            count++;
            shuffleList();
            if (isPossibleMatch(level, crewList)) {
                updateMatchedCrew(level, crewList);
                return matchingCrewList;
            }
        }
        throw new IllegalArgumentException("3번 이상 매칭이 되지 않았습니다!");
    }

    public List<String> shuffleList() {
        return matchingCrewList = Randoms.shuffle(matchingCrewList);
    }

    private boolean isPossibleMatch(Level level, List<Crew> crewList) {
        for (int i = 0; i < matchingCrewList.size() - 2; i = i + 2) {
            Crew crew1 = find(matchingCrewList.get(i), crewList);
            Crew crew2 = find(matchingCrewList.get(i + 1), crewList);
            if (!crew1.isPossibleMatch(level, crew2)) {
                return false;
            }
            if (!crew2.isPossibleMatch(level, crew1)) {
                return false;
            }
        }
        return true;
    }

    private void updateMatchedCrew(Level level, List<Crew> crewList) {
        for (int i = 0; i < matchingCrewList.size() - 2; i = i + 2) {
            Crew temp1 = find(matchingCrewList.get(i), crewList);
            Crew temp2 = find(matchingCrewList.get(i + 1), crewList);
            temp1.putMatchedCrew(level, temp2);
            temp2.putMatchedCrew(level, temp1);
        }
    }

    private Crew find(String crewName, List<Crew> backEndCrewList) {
//        List<Crew> backEndCrewList = crewRepository.getBackEndCrewList();
        for (Crew crew : backEndCrewList) {
            if (crew.isSameName(crewName)) {
                return crew;
            }
        }
        return null;
    }

    public List<String> getMatchingCrewList() {
        return matchingCrewList;
    }
}