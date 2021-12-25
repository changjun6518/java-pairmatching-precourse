package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.util.CrewFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Matching {
    List<String> crewList = CrewFileReader.readCrewList();

    private void shuffleList() {
        List<String> shuffledList = Randoms.shuffle(crewList);
    }
}
