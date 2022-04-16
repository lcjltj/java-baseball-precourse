package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.Constants.*;
import static baseball.enumerate.ExceptionType.*;

public final class User {

    private User() {
    }

    public static List<Integer> inputNumber(final String input) {
        final List<Integer> list = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            list.add(Character.getNumericValue(ch));
        }
        validate(list);

        return list;
    }

    private static void validate(final List<Integer> list) {
        checkLength(list);
        checkOverlap(list);
        checkInput(list);

    }

    private static void checkLength(final List<Integer> list) {
        if (list.size() != LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
        }
    }

    private static void checkOverlap(final List<Integer> list) {
        if (toSet(list).size() != list.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE.getMessage());
        }
    }

    private static Set<Integer> toSet(final List<Integer> list) {
        Set<Integer> set = new HashSet<>();

        for (int value : list) {
            set.add(value);
        }

        return set;
    }

    private static void checkInput(final List<Integer> list) {
        for (int value : list) {
            validateValue(value);
        }
    }

    private static void validateValue(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}
