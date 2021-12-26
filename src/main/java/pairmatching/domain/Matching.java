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

public class Matching {
    private CrewRepository crewRepository = new CrewRepository();
    List<String> crewList = CrewFileReader.readCrewList(BACK_END_FILE_PATH);

    public List<String> shuffleList() {
        return crewList = Randoms.shuffle(crewList);
    }

    public void updateMatchedCrew(Level level) {
        for (int i = 0; i < crewList.size() - 2; i = i + 2) {
            Crew temp1 = find(crewList.get(i));
            Crew temp2 = find(crewList.get(i + 1));
            temp1.putMatchedCrew(level, temp2);
            temp2.putMatchedCrew(level, temp1);
        }
    }

    private Crew find(String crewName) {
        List<Crew> backEndCrewList = crewRepository.getBackEndCrewList();
        for (Crew crew : backEndCrewList) {
            if (crew.isSameName(crewName)) {
                return crew;
            }
        }
        return null;
    }

    public CrewRepository getCrewRepository() {
        return crewRepository;
    }
}