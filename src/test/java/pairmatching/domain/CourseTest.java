package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Course;

public class CourseTest {

    @Test
    public void to_string_test() throws Exception {
        // given
        // when
        // then
        Assertions.assertThat(Course.print()).isEqualTo("과정: 백엔드 | 프론트엔드");
        System.out.println(Course.print());
    }
}
