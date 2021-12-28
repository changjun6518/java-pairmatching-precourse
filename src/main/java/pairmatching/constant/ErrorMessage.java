package pairmatching.constant;

public enum ErrorMessage {
    USER_CHOICE_ERROR_MESSAGE("[ERROR] 1,2,3,Q 중 하나를 입력하시오"),
    INCORRECT_FORM_ERROR_MESSAGE("[ERROR] 과정, 레벨, 미션을 입력하시오"),
    COURSE_ERROR_MESSAGE("[ERROR] 해당 과정이 없습니다"),
    LEVEL_ERROR_MESSAGE("[ERROR] 해당 레벨이 없습니다"),
    MISSION_ERROR_MESSAGE("[ERROR] 해당 미션이 없습니다"),
    REMATCHING_CHOICE_ERROR_MESSAGE("[ERROR] 네 또는 아니오로 대답하시오"),

    ;

    String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
