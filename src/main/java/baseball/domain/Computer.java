package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.GameRule.*;

public final class Computer {

    private final List<Integer> answer;
    private int strike;
    private int ball;
    private boolean successful;

    public Computer() {
        answer = generateRandomNumbers();
        strike = 0;
        ball = 0;
        successful = false;
    }

    public boolean playGame() {
        while (!successful) {
            init();
            InputView.printNumberMessage();
            List<Integer> inputNumber = Play.inputNumbers();
            String message = compareNumber(inputNumber);
            OutputView.printResult(message);
        }

        InputView.printRestartMessage();
        return Play.isRestart();
    }

    private void init() {
        strike = 0;
        ball = 0;
    }

    private String compareNumber(final List<Integer> inputNumber) {
        for (int i = 0; i < inputNumber.size(); i++) {
            countStrike(inputNumber.get(i), i);
            countBall(inputNumber.get(i), i);
        }

        isCorrect();
        return outputMessage();
    }

    private void countStrike(final int num, final int index) {
        if (answer.contains(num) && answer.indexOf(num) == index) {
            strike++;
        }
    }

    private void countBall(final int num, final int index) {
        if (answer.contains(num) && answer.indexOf(num) != index) {
            ball++;
        }
    }

    private void isCorrect() {
        successful = (strike == THREE_STRIKE);
    }

    private String outputMessage() {
        if (strike > STRIKE_ZERO && ball == BALL_ZERO) {
            return String.format(STRIKE_MESSAGE, strike);
        }

        if (strike == STRIKE_ZERO && ball > BALL_ZERO) {
            return String.format(BALL_MESSAGE, ball);
        }

        if (strike > STRIKE_ZERO && ball > BALL_ZERO) {
            return String.format(STRIKE_BALL_MESSAGE, ball, strike);
        }

        return OUT_MESSAGE;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

    private List<Integer> generateRandomNumbers() {
        Set<Integer> numberSet = new HashSet<>();

        while (numberSet.size() < LENGTH) {
            numberSet.add(generateRandomNumber());
        }

        return new ArrayList<>(numberSet);
    }
}