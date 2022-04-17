package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class Judgement {
    public static final String STRIKE = "Strike";
    public static final String BALL = "Ball";
    public static final int LIMIT_OF_STRING_LENGTH = 3;
    public static final int ZERO = 0;
    private final Map<String, Integer> result;

    public Judgement() {
        this.result = new HashMap<>();
        initializeResultMap();
    }

    private void initializeResultMap() {
        result.put(STRIKE, 0);
        result.put(BALL, 0);
    }

    public Map<String, Integer> judge(String inputValue, String answer) {
        validateLength(inputValue);
        initializeResultMap();
        calculateAndStoreResultMap(inputValue, answer);

        return result;
    }

    private void calculateAndStoreResultMap(String inputValue, String answer) {
        int strike = countOfStrike(inputValue, answer);
        int ball = countOfBall(inputValue, answer) - strike;
        if(ball < ZERO) {
            ball = ZERO;
        }
        result.put(BALL, ball);
        result.put(STRIKE, strike);
    }

    private static void validateLength(String value) {
        if (value.length() != LIMIT_OF_STRING_LENGTH) {
            throw new IllegalArgumentException("입력 숫자의 자릿수는 3자리여야 합니다.");
        }
    }

    private int countOfStrike(String inputValue, String answer) {
        char[] characterOfInputValue = inputValue.toCharArray();
        char[] characterOfAnswer = answer.toCharArray();
        int count = 0;
        for (int index = 0; index < LIMIT_OF_STRING_LENGTH; index++) {
            count += valueForStrike(characterOfInputValue, characterOfAnswer, index);
        }
        return count;
    }

    private int valueForStrike(char[] characterOfInputValue, char[] characterOfAnswer, int index) {
        if(characterOfInputValue[index] == characterOfAnswer[index]) {
            return 1;
        }
        return 0;
    }

    private int countOfBall(String inputValue, String answer) {
        int count = 0;
        for (Character c : inputValue.toCharArray()) {
            count += valueForBall(answer, c);
        }
        return count;
    }

    private int valueForBall(String answer, Character c) {
        if (answer.contains(c.toString())) {
            return 1;
        }
        return 0;
    }

}
