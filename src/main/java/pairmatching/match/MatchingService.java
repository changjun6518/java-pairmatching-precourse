package pairmatching.match;

import pairmatching.course.Course;
import pairmatching.level.Level;
import pairmatching.mission.Mission;

public class MatchingService {
    // 페어 매칭을 진행하는 역할
    private static final int TRY_LIMIT = 3;

    private MatchingRepository matchingRepository = new MatchingRepository();

    public MatchingResultDto match(Course course, Level level, Mission mission) {
        MatchingInfo matchingInfo = new MatchingInfo(course, level, mission);
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

        matchingRepository.put(matchingInfo, matchingResult);
        matchingResultDto = matchingResult.convertDto();

        return matchingResultDto;
    }

    public MatchingResultDto lookupMatchingResult(Course course, Level level, Mission mission) {
        if (isExist(course, level, mission)) {
            MatchingResult matchingResult = getMatchingResult(course, level, mission);
            return matchingResult.convertDto();
        }
        throw new IllegalArgumentException("해당 과정 레벨 미션의 매칭이력이 없습니다");
    }

    public boolean isExist(Course course, Level level, Mission mission) {
        MatchingInfo matchingInfo = new MatchingInfo(course, level, mission);
        return matchingRepository.contains(matchingInfo);
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

    private MatchingResult getMatchingResult(Course course, Level level, Mission mission) {
        MatchingInfo matchingInfo = new MatchingInfo(course, level, mission);
        return matchingRepository.get(matchingInfo);
    }
}
