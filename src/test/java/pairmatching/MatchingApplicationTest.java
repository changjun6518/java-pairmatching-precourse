package pairmatching;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MatchingApplicationTest extends NsTest {
    public static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    public void userChoice_validation_test() throws Exception{
        assertSimpleTest(
                () -> {
                    runException("q");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}