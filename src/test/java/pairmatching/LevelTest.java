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
        // when
        // then
        Assertions.assertThat("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임").isEqualTo(Level.LEVEL1.printMissions());
        System.out.println(Level.LEVEL1.printMissions());
    }
}
