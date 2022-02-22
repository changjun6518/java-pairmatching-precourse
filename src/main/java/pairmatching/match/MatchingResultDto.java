package pairmatching.match;

import java.util.List;

public class MatchingResultDto {
    public List<List<String>> matchingResults;

    public MatchingResultDto(List<List<String>> matchingResults) {
        this.matchingResults = matchingResults;
    }
}
