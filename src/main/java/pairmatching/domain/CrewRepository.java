package pairmatching.domain;

import pairmatching.util.CrewFileReader;

import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.constant.SystemMessage.BACK_END_FILE_PATH;

public class CrewRepository {
    private List<Crew> crewList;

    public CrewRepository() {
        initCrewList();
    }

    private void initCrewList() {
        List<String> stringList = CrewFileReader.readCrewList(BACK_END_FILE_PATH);
        crewList = stringList.stream()
                .map(Crew::new)
                .collect(Collectors.toList());
    }
}
