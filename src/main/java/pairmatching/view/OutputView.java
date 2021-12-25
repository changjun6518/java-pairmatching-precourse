package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

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
}
