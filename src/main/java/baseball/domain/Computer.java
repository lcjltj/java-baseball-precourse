package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static baseball.constant.Constants.*;

public final class Computer {

    private static final Computer INSTANCE = new Computer();
    private List<Integer> numbers;

    private Computer() {
    }

    public static Computer getInstance() {
        INSTANCE.numbers = generateRandomNumber();
        return INSTANCE;
    }

    private static List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, LENGTH);
    }

}