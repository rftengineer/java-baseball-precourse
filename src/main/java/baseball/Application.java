package baseball;

import baseball.config.BaseballGameConfig;
import baseball.model.Game;
import baseball.model.Judgement;
import baseball.model.enumeration.GameRule;
import baseball.model.generator.NumbersForGameGenerator;
import baseball.model.generator.RandomGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean keepPlaying = true;
        RandomGenerator randomGenerator = new NumbersForGameGenerator(BaseballGameConfig.MIN_VALUE
                , BaseballGameConfig.MAX_VALUE
                , BaseballGameConfig.LENGTH_OF_INPUT);
        Judgement judgement = new Judgement(BaseballGameConfig.LENGTH_OF_INPUT);
        while (keepPlaying) {
            keepPlaying = doGame(randomGenerator, judgement, BaseballGameConfig.CONDITION_FOR_WIN);
        }
    }

    private static boolean doGame(RandomGenerator gameGenerator, Judgement judgement1, final int conditionForWin) {
        Map<GameRule, Integer> judge;
        String answer = String.valueOf(gameGenerator.generate());
        do {
            judge = judgement1.judge(InputView.enterDigitValue(), answer);
            OutputView.showResultWithGameScore(Game.currentScore(judge));
        } while (!Game.isGameOver(judge, conditionForWin));
        OutputView.clearTheGame();
        return parseUserInputForKeepPlaying(InputView.enterGameKeepGoing());
    }

    private static boolean parseUserInputForKeepPlaying(String enterGameKeepGoing) {
        if ("1".equals(enterGameKeepGoing)) {
            return true;
        }
        if ("2".equals(enterGameKeepGoing)) {
            return false;
        }
        throw new IllegalArgumentException("잘못된 입력값입니다. 종료합니다.");
    }
}
