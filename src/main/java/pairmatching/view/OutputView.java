package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.MissionFactory;

public class OutputView {
    public static void printProcessLevelMission() {
        MissionFactory.init();
        System.out.println("#############################################\n" +
                            Course.print() + "\n" +
                            "미션:\n" +
                            MissionFactory.level1.printMissions() + "\n" +
                            MissionFactory.level2.printMissions() + "\n" +
                            MissionFactory.level3.printMissions() + "\n" +
                            MissionFactory.level4.printMissions() + "\n" +
                            MissionFactory.level5.printMissions() + "\n" +
                            "############################################");
    }
}
