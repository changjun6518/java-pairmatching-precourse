package pairmatching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Level;

import java.util.ArrayList;
import java.util.List;

public class LevelTest {
    @Test
    public void to_string_test() throws Exception {
        // given
        Level level = Level.LEVEL1;

        // when
        List<String> missionList = new ArrayList<>();
        missionList.add("자동차경주");
        missionList.add("로또");
        missionList.add("숫자야구게임");
        level.setMissions(missionList);

        // then
        Assertions.assertThat("레벨1: 자동차경주 | 로또 | 숫자야구게임").isEqualTo(level.printMissions());
        System.out.println(level.printMissions());
    }
}
