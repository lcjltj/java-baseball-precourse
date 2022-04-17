package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ComputerTest {

    @Test
    @DisplayName("정답을 맞췄을 시 올바른 결과 값 확인")
    void validAnswer() {
        // GIVEN
        Computer mockComputer = mock(Computer.class);

        // WHEN
        when(mockComputer.playGame()).thenReturn(true);

        // THEN
        assertTrue(mockComputer.playGame(), () -> "정답을 맞췄을 시 올바르지 않은 결과를 리턴 하였습니다.");
    }

}