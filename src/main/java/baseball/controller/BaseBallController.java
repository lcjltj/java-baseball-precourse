package baseball.controller;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallController {

    private BaseBallController() {
    }

    public static void start() {
        boolean continued = true;

        while (continued) {
            Computer computer = new Computer();
            continued = computer.playGame();
        }

    }

    public static String inputNumber() {
        return Console.readLine();
    }
}
