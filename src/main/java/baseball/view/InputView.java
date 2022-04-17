package baseball.view;

import static baseball.constant.GameRule.*;

public class InputView {

    private InputView() {
    }

    public static void printNumberMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void printRestartMessage() {
        System.out.println(SUCCESS_MESSAGE);
        System.out.println(INPUT_RESTART_MESSAGE);
    }

}
