package baseball.view;

import static baseball.constant.GameRule.EXIT_MESSAGE;

public class OutputView {

    public OutputView() {
    }

    public static void printResult(final String message) {
        System.out.println(message);
    }

    public static void endMessage() {
        System.out.println(EXIT_MESSAGE);
    }

}
