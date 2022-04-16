package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요 :";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작 하려면 1, 종료 하려면 2를 입력 하세요";

    private InputView() {}

    public static String printNumberMessage() {
        System.out.println(INPUT_NUMBER_MESSAGE);
        return readLine();
    }

    public static String printRestartMessage() {
        System.out.println(INPUT_RESTART_MESSAGE);
        return readLine();
    }

}
