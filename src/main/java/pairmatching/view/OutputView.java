package pairmatching.view;

import pairmatching.match.MatchingResult;
import pairmatching.match.MatchingResultDto;

import java.util.List;

public class OutputView {
    public static void printMatchingResult(MatchingResultDto matchingResultDto) {
        for (List<String> pair : matchingResultDto.matchingResults) {
            System.out.println(String.join(" : ", pair));
        }
    }

    public static void printDeleteMessage() {
        System.out.println("모든 정보가 초기화 됐습니다");
    }
}
