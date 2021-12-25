package pairmatching.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Matching;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrewFileReaderTest {
    @Test
    public void read_file_test() throws Exception{
        // given
        // when
        List<String> crewList = CrewFileReader.readCrewList();
        // then
        Assertions.assertThat(crewList.contains("백호")).isEqualTo(true);
        Assertions.assertThat(crewList.contains("태웅")).isEqualTo(true);
    }
}