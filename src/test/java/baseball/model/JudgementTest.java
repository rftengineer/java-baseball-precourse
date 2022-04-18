package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import baseball.model.enumeration.GameRule;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JudgementTest {

    @ParameterizedTest
    @CsvSource(value = {"4533, 354", "1, 245", "24, 354"})
    void CsvSource_Test_For_Length3_Judgement(String inputValue, String answer) {
        Judgement judgement = new Judgement();

        assertThatThrownBy(() -> judgement.judge(inputValue, answer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 숫자의 자릿수는 3자리여야 합니다.");

    }

    @ParameterizedTest
    @CsvSource(value = {"354, 153, 1", "123, 456, 0", "132, 213, 3", "156,573, 1"})
    void CsvSource_Test_For_Ball_Judgement(String inputValue, String answer, int expected) {
        Judgement judgement = new Judgement();
        assertThat(judgement.judge(inputValue, answer).get(GameRule.BALL)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123, 154, 1", "123, 124, 2", "135, 135, 3", "123, 456, 0"})
    void CsvSource_Test_For_Strike_Judgement(String inputValue, String answer, int expected) {
        Judgement judgement = new Judgement();
        assertThat(judgement.judge(inputValue, answer).get(GameRule.STRIKE)).isEqualTo(expected);
    }
}
