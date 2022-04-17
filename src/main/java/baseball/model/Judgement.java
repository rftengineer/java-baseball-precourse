package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class Judgement {

    public Map<String, Integer> judge(String inputValue, String answer) {
        validateLength(inputValue);
        int ball = countOfBall(inputValue, answer);
        int strike = countOfStrike(inputValue, answer);
        Map<String, Integer> result = new HashMap<>();
        result.putIfAbsent("Ball", ball);
        result.putIfAbsent("Strike", strike);

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
            count += characterOfInputValue[index] == characterOfAnswer[index] ? 1 : 0;
        }
        return count;
    }

    private int countOfBall(String inputValue, String answer) {
        int count = 0;
        for (Character c : inputValue.toCharArray()) {
            count += answer.contains(c.toString()) ? 1 : 0;
        }
        return count;
    }

}
