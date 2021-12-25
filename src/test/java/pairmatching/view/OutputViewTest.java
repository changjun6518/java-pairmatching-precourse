package pairmatching.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.util.CrewFileReader;

import static org.junit.jupiter.api.Assertions.*;
import static pairmatching.constant.SystemMessage.BACK_END_FILE_PATH;
import static pairmatching.constant.SystemMessage.FRONT_END_FILE_PATH;

class OutputViewTest {
    @Test
    public void printProcessLevelMission_Test() throws Exception{
        // then
        OutputView.printProcessLevelMission();
    }

    @Test
    public void print_matching_result() throws Exception {
        // given
        // when
        // then
        OutputView.printMatchingResult(CrewFileReader.readCrewList(FRONT_END_FILE_PATH));
    }

}