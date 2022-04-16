package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.view.InputView;

import java.util.List;

public class BaseBallController {

    private static boolean play;
    private static Computer computer;

    private BaseBallController() {

    }

    public static void start() {
        play = true;
        computer = Computer.getInstance();

        while (play) {
            inputNumber();
        }
    }

    private static void inputNumber() {
        final List<Integer> list = User.inputNumber(InputView.printNumberMessage());
    }

    private static void requestRestart() {
    }

}
