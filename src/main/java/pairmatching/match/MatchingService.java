package pairmatching.match;

import pairmatching.course.Course;
import pairmatching.level.Level;

public class MatchingService {
    // 페어 매칭을 진행하는 역할
    private static final int TRY_LIMIT = 3;

    private MatchingRepository matchingRepository = new MatchingRepository();

    public void match(Level level, Course course) {
        int tryCount = 0;
        boolean success;
        Matching matching = new Matching(course.getStringCrews());
        do {
            success = matching.match(level, course.getCrews());
            tryCount++;
        } while (!success && tryCount < TRY_LIMIT);

        if (isSuccessMatching(success, tryCount)) {
            matchingRepository.add(matching);
        }
    }

    private boolean isSuccessMatching(boolean success, int tryCount) {
        if (success && tryCount < TRY_LIMIT) {
            return true;
        }
        throw new IllegalArgumentException("3번 이상 페어 조합 실패!");
    }
}
