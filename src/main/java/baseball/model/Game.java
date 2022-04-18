package baseball.model;

import baseball.model.enumeration.GameRule;
import java.util.Map;

public class Game {

    public static final int CONDITION_FOR_WIN = 3;

    public static boolean isGameOver(Map<GameRule, Integer> result) {
        return result.get(GameRule.STRIKE) == CONDITION_FOR_WIN;
    }

    public static String currentScore(Map<GameRule, Integer> result) {
        String ball = StringUtilsForGame.validateAndResult(GameRule.BALL, result.get(GameRule.BALL));
        String strike = StringUtilsForGame.validateAndResult(GameRule.STRIKE, result.get(GameRule.STRIKE));
        return StringUtilsForGame.concatResult(ball, strike);
    }

}
