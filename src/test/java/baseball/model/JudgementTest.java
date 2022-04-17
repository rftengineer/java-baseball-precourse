package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JudgementTest {

    @ParameterizedTest
    @CsvSource(value = {"453,true", "535,true", "23,false", "4423,false", "5,false"})
    void CsvSource_Test_For_Length3_Judgement(String element, boolean expected) {
        assertThat(Judgement.judge(element)).isEqualTo(expected);
    }
}
