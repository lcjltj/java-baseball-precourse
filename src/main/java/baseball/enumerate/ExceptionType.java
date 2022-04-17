package baseball.enumerate;

public enum ExceptionType {
    INVALID_LENGTH("세 자리의 숫자만 입력 가능 합니다."),
    INVALID_DUPLICATE("중복된 숫자는 입력이 불가능 합니다."),
    INVALID_INPUT("1~9의 숫자만 입력 가능 합니다."),
    INVALID_RESTART_INPUT("재시작 1 , 종료 2 입력만 가능합니다.");

    private final String message;

    ExceptionType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
