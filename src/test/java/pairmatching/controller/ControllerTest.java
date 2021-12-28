package pairmatching.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import pairmatching.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest extends NsTest {
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

    @Test
    public void mission_validation_test() throws Exception{
        assertSimpleTest(
                () -> {
                    runException("1", "백엔드, 레벨1, 오징어게임");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    public void course_validation_test() throws Exception{
        assertSimpleTest(
                () -> {
                    runException("1", "엔드, 레벨1, 자동차경주");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    public void level_validation_test() throws Exception{
        assertSimpleTest(
                () -> {
                    runException("1", "백엔드, 레벨7, 자동차경주");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    public void rematching_choice_validation_test() throws Exception{
        assertSimpleTest(
                () -> {
                    runException("1", "백엔드, 레벨1, 자동차경주","1", "백엔드, 레벨1, 자동차경주","넹");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


}