package baseball.model.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class NumbersForGameGenerator implements RandomGenerator {

    private final int MIN_VALUE;
    private final int MAX_VALUE;
    private final int LENGTH_OF_NUMBER;

    public NumbersForGameGenerator(int minValue, int maxValue, int count) {
        this.MAX_VALUE = maxValue;
        this.MIN_VALUE = minValue;
        this.LENGTH_OF_NUMBER = count;
    }

    @Override
    public int generate() {
        return generateNumbers(LENGTH_OF_NUMBER);
    }

    private int generateNumberUsingRandoms(int minNumber, int maxNumber) {
        return Randoms.pickNumberInRange(minNumber, maxNumber);
    }

    private int generateNumbers(final int count) {
        int value = 0;
        for(int loop = 0; loop < count; loop++) {
            value *= 10;
            value += generateNumberUsingRandoms(MIN_VALUE, MAX_VALUE);
        }
        return value;
    }
}
