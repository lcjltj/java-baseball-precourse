package baseball.domain;

import baseball.controller.BaseBallController;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.GameRule.*;
import static baseball.enumerate.ExceptionType.*;

public final class Play {

    private static final Play INSTANCE = new Play();

    private Play() {
    }

    public static List<Integer> inputNumbers() {
        final List<Integer> inputNumbers = new ArrayList<>();

        for (char ch : inputNumber().toCharArray()) {
            inputNumbers.add(Character.getNumericValue(ch));
        }

        INSTANCE.validate(inputNumbers);

        return inputNumbers;
    }

    public static boolean isRestart() {
        String inputNumber = inputNumber();
        INSTANCE.validateRestart(inputNumber);

        if (RESTART.equals(inputNumber)) {
            return true;
        }

        OutputView.endMessage();
        return false;
    }

    private void validateRestart(final String inputNumber) {
        if (!(RESTART.equals(inputNumber) || EXIT.equals(inputNumber))) {
            throw new IllegalArgumentException(INVALID_RESTART_INPUT.getMessage());
        }
    }

    private static String inputNumber() {
        return BaseBallController.inputNumber();
    }

    private void validate(final List<Integer> inputNumbers) {
        checkLength(inputNumbers);
        checkOverlap(inputNumbers);
        checkInput(inputNumbers);
    }

    private void checkLength(final List<Integer> inputNumbers) {
        if (inputNumbers.size() != LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
        }
    }

    private void checkOverlap(final List<Integer> inputNumbers) {
        if (toSet(inputNumbers).size() != inputNumbers.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE.getMessage());
        }
    }

    private Set<Integer> toSet(final List<Integer> inputNumbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (int value : inputNumbers) {
            numberSet.add(value);
        }

        return numberSet;
    }

    private void checkInput(final List<Integer> inputNumbers) {
        for (int number : inputNumbers) {
            validateValue(number);
        }
    }

    private void validateValue(final int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}
