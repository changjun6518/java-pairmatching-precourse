package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MissionFactory {
    public static Level level1 = Level.LEVEL1;
    public static Level level2 = Level.LEVEL2;
    public static Level level3 = Level.LEVEL3;
    public static Level level4 = Level.LEVEL4;
    public static Level level5 = Level.LEVEL5;

    public static void init() {
        List<String> missionList1 = new ArrayList<>();
        missionList1.add("자동차경주");
        missionList1.add("로또");
        missionList1.add("숫자야구게임");
        level1.setMissions(missionList1);

        List<String> missionList2 = new ArrayList<>();
        missionList2.add("장바구니");
        missionList2.add("결제");
        missionList2.add("지하철노선도");
        level2.setMissions(missionList2);

        List<String> missionList4 = new ArrayList<>();
        missionList4.add("성능개선");
        missionList4.add("배포");
        level4.setMissions(missionList4);
    }
}
