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
}
