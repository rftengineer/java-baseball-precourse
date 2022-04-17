package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class Judgement {
    public static final String STRIKE = "Strike";
    public static final String BALL = "Ball";
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
        int strike = countOfStrike(inputValue, answer);
        int ball = countOfBall(inputValue, answer) - strike;
        if(ball < 0) {
            ball = 0;
        }
        result.put(BALL, ball);
        result.put(STRIKE, strike);

        return result;
    }

    private static void validateLength(String value) {
        if (value.length() != 3) {
            throw new IllegalArgumentException("입력 숫자의 자릿수는 3자리여야 합니다.");
        }
    }

    private int countOfStrike(String inputValue, String answer) {
        char[] characterOfInputValue = inputValue.toCharArray();
        char[] characterOfAnswer = answer.toCharArray();
        int count = 0;
        for (int index = 0; index < 3; index++) {
            count += isCharacterStrike(characterOfInputValue, characterOfAnswer, index);
        }
        return count;
    }

    private int isCharacterStrike(char[] characterOfInputValue, char[] characterOfAnswer, int index) {
        return characterOfInputValue[index] == characterOfAnswer[index] ? 1 : 0;
    }

    private int countOfBall(String inputValue, String answer) {
        int count = 0;
        for (Character c : inputValue.toCharArray()) {
            count += isCharacterBall(answer, c);
        }
        return count;
    }

    private int isCharacterBall(String answer, Character c) {
        return answer.contains(c.toString()) ? 1 : 0;
    }

}
