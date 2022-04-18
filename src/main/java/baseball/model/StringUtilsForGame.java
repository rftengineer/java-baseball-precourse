package baseball.model;

import baseball.model.enumeration.GameRule;

public class StringUtilsForGame {
    public static String concatResult(String ball, String strike) {
        if (ball.equals("") && strike.equals("")) {
            return "낫싱";
        }
        return String.join(" ", ball, strike).trim();
    }

    public static String validateAndResult(GameRule category, Integer value) {
        if (value == 0) {
            return "";
        }
        if (category.equals(GameRule.STRIKE)) {
            return value + "스트라이크";
        }
        if (category.equals(GameRule.BALL)) {
            return value + "볼";
        }
        return "";
    }
}