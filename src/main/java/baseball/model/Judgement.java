package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class Judgement {
    private final Map<String, Integer> result;

    public Judgement() {
        this.result = new HashMap<>();
        initializeResultMap();
    }

    private void initializeResultMap() {
        result.put("Strike", 0);
        result.put("Ball", 0);
    }

    public Map<String, Integer> judge(String inputValue, String answer) {
        validateLength(inputValue);
        initializeResultMap();
        int ball = countOfBall(inputValue, answer);
        int strike = countOfStrike(inputValue, answer);
        Map<String, Integer> result = new HashMap<>();
        result.put("Ball", ball);
        result.put("Strike", strike);

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
