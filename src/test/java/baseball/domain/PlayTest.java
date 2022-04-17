package baseball.domain;

import baseball.enumerate.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayTest {

    @Test
    @DisplayName("입력 값 List 변환")
    void inputToList() {
        // GIVEN
        String input = "156";

        // WHEN
        command(input);
        List<Integer> list = Play.inputNumbers();
        command(input);

        // THEN
        assertAll(() -> {
            assertInstanceOf(List.class, Play.inputNumbers(), () -> "LIST 타입이 아닙니다.");
            assertEquals(3, list.size(), () -> "입력한 값과 길이가 일치 하지 않습니다.");
        });
    }

    @Test
    @DisplayName("입력 값 중복 확인")
    void validDuplicate() {
        // GIVEN
        String input = "446";
        String message = "";

        // WHEN
        try {
            command(input);
            Play.inputNumbers();
        } catch (IllegalArgumentException e) {
            message = e.getMessage();
        }
        final String errorMessage = message;
        command(input);

        // THEN
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> Play.inputNumbers(), () -> "중복된 입력에 대한 올바르지 않은 Exception 발생.");
            assertEquals(ExceptionType.INVALID_DUPLICATE.getMessage(), errorMessage);
        });

    }

    @Test
    @DisplayName("입력 값 자릿수 확인")
    void validLength() {
        // GIVEN
        String input = "1000";
        String message = "";

        // WHEN
        try {
            command(input);
            Play.inputNumbers();
        } catch (IllegalArgumentException e) {
            message = e.getMessage();
        }
        final String errorMessage = message;
        command(input);

        // THEN
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> Play.inputNumbers(), () -> "자릿수 에 대한 올바르지 않은 Exception 발생.");
            assertEquals(ExceptionType.INVALID_LENGTH.getMessage(), errorMessage);
        });
    }

    @Test
    @DisplayName("입력한 범위 확인")
    void validateRange() {
        // GIVEN
        String input = "019";
        String message = "";

        // WHEN
        try {
            command(input);
            Play.inputNumbers();
        } catch (IllegalArgumentException e) {
            message = e.getMessage();
        }
        final String errorMessage = message;
        command(input);

        // THEN
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> Play.inputNumbers(), () -> "잘못된 범위에 대한 올바르지 않은 Exception 발생.");
            assertEquals(ExceptionType.INVALID_INPUT.getMessage(), errorMessage);
        });

    }

    @Test
    @DisplayName("재시작/종료 입력 값 확인")
    void validInputRestart() {
        // GIVEN
        String input = "3";
        String message = "";

        // WHEN
        try {
            command(input);
            Play.isRestart();
        } catch (IllegalArgumentException e) {
            message = e.getMessage();
        }
        final String errorMessage = message;
        command(input);

        // THEN
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> Play.inputNumbers(), () -> "재시작(1)/ 종료(2) 대한 올바르지 않은 Exception 발생.");
            assertEquals(ExceptionType.INVALID_RESTART_INPUT.getMessage(), errorMessage);
        });
    }

    private void command(final String input) {
        final byte[] buf = input.getBytes(StandardCharsets.UTF_8);
        System.setIn(new ByteArrayInputStream(buf));
    }
}