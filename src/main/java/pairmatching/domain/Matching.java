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
    List<String> crewList = CrewFileReader.readCrewList(BACK_END_FILE_PATH);

    public List<String> shuffleList() {
        return Randoms.shuffle(crewList);
    }
}
