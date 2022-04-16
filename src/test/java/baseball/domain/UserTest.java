package baseball.domain;

import baseball.enumerate.ExceptionType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void 입력값_List_변환() {
        // GIVEN
        String input = "156";

        // WHEN
        List<Integer> list = User.inputNumber(input);

        // THEN
        assertAll(() -> {
            assertInstanceOf(List.class, User.inputNumber(input), () -> "LIST 타입이 아닙니다.");
            assertEquals(3, list.size(), () -> "입력한 값과 길이가 일치 하지 않습니다.");
        });
    }

    @Test
    void 입력_중복값_확인() {
        // GIVEN
        String input = "446";
        String message = "";

        // WHEN
        try {
            User.inputNumber(input);
        } catch (IllegalArgumentException e) {
            message = e.getMessage();
        }
        final String errorMessage = message;

        // THEN
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> User.inputNumber(input), () -> "중복된 입력에 대한 올바르지 않은 Exception 발생.");
            assertEquals(ExceptionType.INVALID_DUPLICATE.getMessage(), errorMessage);
        });

    }

    @Test
    void 세자리_입력_확인() {
        // GIVEN
        String input = "1000";
        String message = "";

        // WHEN
        try {
            User.inputNumber(input);
        } catch (IllegalArgumentException e) {
            message = e.getMessage();
        }
        final String errorMessage = message;

        // THEN
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> User.inputNumber(input), () -> "자릿수 에 대한 올바르지 않은 Exception 발생.");
            assertEquals(ExceptionType.INVALID_LENGTH.getMessage(), errorMessage);
        });
    }

    @Test
    void 잘못된_범위_입력_확인() {
        // GIVEN
        String input = "019";
        String message = "";

        // WHEN
        try {
            User.inputNumber(input);
        } catch (IllegalArgumentException e) {
            message = e.getMessage();
        }
        final String errorMessage = message;

        // THEN
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> User.inputNumber(input), () -> "잘못된 범위에 대한 올바르지 않은 Exception 발생.");
            assertEquals(ExceptionType.INVALID_INPUT.getMessage(), errorMessage);
        });

    }
}