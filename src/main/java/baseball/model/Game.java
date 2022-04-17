package baseball.model;

import java.util.Map;

public class Game {

    public static final int CONDITION_FOR_WIN = 3;

    public static boolean isGameOver(Map<String, Integer> result) {
        return result.get("Strike") == CONDITION_FOR_WIN;
    }

    public static String currentScore(Map<String, Integer> result) {
        String ball = StringUtilsForGame.validateAndResult("Ball", result.get("Ball"));
        String strike = StringUtilsForGame.validateAndResult("Strike", result.get("Strike"));
        return StringUtilsForGame.concatResult(ball, strike);
    }

}
