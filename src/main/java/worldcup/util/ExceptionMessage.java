package worldcup.util;

public enum ExceptionMessage {

    INVALID_NOT_NUMERIC("자연수만 입력 가능합니다."),
    INVALID_OUT_OF_INT_RANGE("입력 범위를 초과하였습니다."),
    NO_MAIN_OPTION("해당 메인 옵션이 존재하지 않습니다."),
    NO_GROUP("해당 조가 존재하지 않습니다."), NO_TEAM("해당 국가가 존재하지 않습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}