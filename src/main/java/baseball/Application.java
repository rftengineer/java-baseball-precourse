package baseball;

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
        RandomGenerator randomGenerator = new NumbersForGameGenerator(1, 9, 3);
        Judgement judgement = new Judgement();
        while (keepPlaying) {
            keepPlaying = doGame(randomGenerator, judgement);
        }
    }

    private static boolean doGame(RandomGenerator gameGenerator, Judgement judgement1) {
        Map<GameRule, Integer> judge;
        String answer = String.valueOf(gameGenerator.generate());
        do {
            judge = judgement1.judge(InputView.enterDigitValue(), answer);
            OutputView.showResultWithGameScore(Game.currentScore(judge));
        } while (!Game.isGameOver(judge));
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
