package pairmatching.view;

import pairmatching.match.MatchingInfoDto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String getUserChoice() {
        try {
            return br.readLine();
        } catch (Exception e) {
            System.out.println("1, 2, 3, Q 중 하나를 입력해주세요");
            return getUserChoice();
        }
    }

    public static MatchingInfoDto getRequiredMatchingInfo() {
        try {
            System.out.println("과정, 레벨, 미션을 선택하세요.");
            String requiredMatchingInfo = br.readLine();
            boolean matches = Pattern.matches(".+, .+, .+", requiredMatchingInfo);
            if (matches) {
                String[] split = requiredMatchingInfo.split(", ");
                return new MatchingInfoDto(split[0], split[1], split[2]);
            }
            throw new IllegalArgumentException("과정, 레벨, 미션 순으로 형식을 맞춰 입력하시오!");
        } catch (Exception e) {
            System.out.println("제대로된 과정, 레벨, 미션을 입력해주세요");
            return getRequiredMatchingInfo();
        }
    }

    public static Boolean getReMatching() {
        try {
            System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
            System.out.println("네 | 아니오");
            String reMatchingMessage = br.readLine();
            if (Pattern.matches("(네|아니오)", reMatchingMessage)) {
                if (reMatchingMessage.equals("네")) {
                    return true;
                } else if (reMatchingMessage.equals("아니오")) {
                    return false;
                }
            }
            throw new IllegalArgumentException("네 아니오로 대답하시오!");
        } catch (Exception e) {
            e.printStackTrace();
            return getReMatching();
        }
        
    }
}
