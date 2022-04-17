package baseball.model;

import java.util.Map;

public class Game {

    public static boolean isGameOver(Map<String, Integer> result) {
        return result.get("Strike") == 3;
    }

    public static String currentScore(Map<String, Integer> result) {
        String ball = validateAndResult("Ball", result.get("Ball"));
        String strike = validateAndResult("Strike", result.get("Strike"));
        return concatResult(ball, strike);
    }

    private static String concatResult(String ball, String strike) {
        if(ball.equals("") && strike.equals("")) {
            return "낫싱";
        }
        return String.join(" ", ball, strike).trim();
    }

    private static String validateAndResult(String category, Integer value) {
        if(value == 0) {
            return "";
        }
        if (category.equals("Strike")) {
            return value + "스트라이크";
        }
        if (category.equals("Ball")) {
            return value + "볼";
        }
        return "";
    }
}
