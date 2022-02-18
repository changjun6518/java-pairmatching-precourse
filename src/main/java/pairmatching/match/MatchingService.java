package pairmatching.match;

import pairmatching.course.Course;
import pairmatching.level.Level;

public class MatchingService {
    // 페어 매칭을 진행하는 역할
    private static final int TRY_LIMIT = 3;

    private MatchingRepository matchingRepository = new MatchingRepository();

    public MatchingResultDto match(Level level, Course course) {
        int tryCount = 0;
        MatchingResultDto matchingResultDto;
        Matching matching = new Matching(course.getStringCrews());
        do {
            matchingResultDto = matching.match(level, course.getCrews());
            tryCount++;
        } while (matchingResultDto.isFailedMatching() && tryCount < TRY_LIMIT);

        if (isSuccessMatching(matchingResultDto.isSuccessMatching(), tryCount)) {
            matchingRepository.add(matching);
            return matchingResultDto;
        }
        throw new IllegalArgumentException("3번 이상 페어 조합 실패!");
    }

    private boolean isSuccessMatching(boolean success, int tryCount) {
        return success && tryCount < TRY_LIMIT;
    }
}
