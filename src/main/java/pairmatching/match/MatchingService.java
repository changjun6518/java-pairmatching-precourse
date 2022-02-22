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
        MatchingResult matchingResult;
        do {
            matchingResult = matching.match(level, course.getCrews());
            tryCount++;
        } while (matchingResult.isFailedMatching() && tryCount < TRY_LIMIT);

        checkSuccessMatching(matchingResult);
        checkTryMatching(tryCount);

        matchingResultDto = matchingResult.convertDto();

        matchingRepository.add(matching);
        return matchingResultDto;
    }

    private void checkSuccessMatching(MatchingResult matchingResult) {
        if (matchingResult.isFailedMatching()) {
            throw new IllegalArgumentException("3번 이상 페어 조합 실패!");
        }
    }

    private void checkTryMatching(int tryCount) {
        if (tryCount > TRY_LIMIT) {
            throw new IllegalArgumentException("3번 이상 페어 조합 실패!");
        }
    }
}
