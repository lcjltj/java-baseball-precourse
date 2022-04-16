package baseball.controller;

import baseball.domain.Computer;

public class BaseBallController {

    private static boolean play;
    private static Computer computer;

    public static void start() {
        play = true;
        computer = Computer.getInstance();

        while (play) {
        }
    }

    public static void requestRestart() {
    }

}
