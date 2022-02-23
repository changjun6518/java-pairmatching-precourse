package pairmatching.course;

import pairmatching.course.util.CrewFileReader;
import pairmatching.crew.Crew;
import pairmatching.crew.Crews;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public enum Course {
    BACK_END("백엔드", "./src/main/resources/backend-crew.md"),
    FRONT_END("프론트", "./src/main/resources/frontend-crew.md"),
    ;

    static{
        for (Course course : Course.values()) {
            course.initCrews();
        }
    }

    private String name;
    private String filePath;
    private Crews crews;

    Course(String name, String filePath) {
        this.name = name;
        this.filePath = filePath;
    }

    private void initCrews() {
        crews = CrewFileReader.readCrews(filePath);
    }

    public List<String> getStringCrews() {
        return crews.returnStringList();
    }

    public Crews getCrews() {
        return crews;
    }

    public static Course of(String name) {
        return Arrays.stream(Course.values()).
                filter(course -> course.isSameName(name))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public static void deleteAll() {
        for (Course course : Course.values()) {
            course.crews.deleteAll();
        }
    }

    private boolean isSameName(String name) {
        return this.name.equals(name);
    }
}
