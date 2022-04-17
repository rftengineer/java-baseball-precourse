package baseball.model;

public class StringUtilsForGame {
    public static String concatResult(String ball, String strike) {
        if (ball.equals("") && strike.equals("")) {
            return "낫싱";
        }
        return String.join(" ", ball, strike).trim();
    }

    public static String validateAndResult(String category, Integer value) {
        if (value == 0) {
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