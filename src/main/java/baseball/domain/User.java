package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public final class User {

    private User() {
    }

    public static List<Integer> inputNumber(final String input) {
        List<Integer> list = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            list.add(Character.getNumericValue(ch));
        }

        return list;
    }

}
