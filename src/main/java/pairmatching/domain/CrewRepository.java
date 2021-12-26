package pairmatching.domain;

import pairmatching.util.CrewFileReader;

import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.constant.SystemMessage.BACK_END_FILE_PATH;

public class CrewRepository {
    private List<Crew> backEndCrewList;
    private List<Crew> frontEndCrewList;

    public CrewRepository() {
        initCrewList();
    }

    private void initCrewList() {
        List<String> backStringList = CrewFileReader.readCrewList(BACK_END_FILE_PATH);
        List<String> frontStringList = CrewFileReader.readCrewList(BACK_END_FILE_PATH);
        backEndCrewList = backStringList.stream()
                .map(Crew::new)
                .collect(Collectors.toList());
        frontEndCrewList = frontStringList.stream()
                .map(Crew::new)
                .collect(Collectors.toList());
    }
}
