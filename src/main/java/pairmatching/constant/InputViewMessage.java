package pairmatching.constant;

public enum InputViewMessage {
    ASK_USER_CHOICE_MESSAGE("기능을 선택하세요."),
    ASK_COURSE_LEVEL_MISSION("과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주"),

    ;
    private String message;

    InputViewMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
