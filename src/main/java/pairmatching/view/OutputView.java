package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

import java.util.List;

public class OutputView {
    public static void printProcessLevelMission() {
        System.out.println("#############################################\n" +
                            Course.print() + "\n" +
                            "미션:\n" +
                            Level.LEVEL1.printMissions() + "\n" +
                            Level.LEVEL2.printMissions() + "\n" +
                            Level.LEVEL3.printMissions() + "\n" +
                            Level.LEVEL4.printMissions() + "\n" +
                            Level.LEVEL5.printMissions() + "\n" +
                            "############################################");
    }

    public static void printMatchingResult(List<String> crewList) {
        System.out.println("페어 매칭 결과입니다.");
        if (crewList.size() % 2 == 0) {
            for (int i = 0; i < crewList.size(); i = i + 2) {
                System.out.println(String.join(" : ", crewList.subList(i, i + 2)));
            }
        } else {
            for (int i = 0; i < crewList.size(); i = i + 2) {
                if (i == crewList.size() - 3) {
                    System.out.println(String.join(" : ", crewList.subList(i, i + 3)));
                    return;
                }
                System.out.println(String.join(" : ", crewList.subList(i, i + 2)));
            }
        }
    }
}
