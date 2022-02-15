package pairmatching.course;

import pairmatching.course.util.CrewFileReader;
import pairmatching.crew.Crew;
import pairmatching.crew.Crews;

import java.util.List;

public enum Course {
    BACK_END("백엔드 과정", "./src/main/resources/backend-crew.md"),
    FRONT_END("프론트 과정", "./src/main/resources/frontend-crew.md"),
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
}
