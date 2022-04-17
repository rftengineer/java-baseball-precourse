package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class GameTest {

    private static Stream<Arguments> provideMapWith3Strike() {
        return Stream.of(
                Arguments.of(3, true),
                Arguments.of(2, false),
                Arguments.of(1, false),
                Arguments.of(0, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideMapWith3Strike")
    void isGameOver_With_Param_Using_Stream(Integer value, boolean expected) {
        Map<String, Integer> result = new HashMap<>();
        result.put("Strike", value);

        assertThat(Game.isGameOver(result)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3, true", "2, false", "1, false", "0, false"})
    void isGameOver_With_Param(Integer value, boolean expected) {
        Map<String, Integer> result = new HashMap<>();
        result.put("Strike", value);

        assertThat(Game.isGameOver(result)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1, 1볼 1스트라이크", "2, 1, 1볼 2스트라이크", "0, 0, 낫싱", "1, 0, 1스트라이크"
            , "0, 1, 1볼"})
    void checkCurrentScoreWithString(Integer strikeValue, Integer ballValue,
                                     String expected) {
        Map<String, Integer> result = new HashMap<>();
        result.put("Strike", strikeValue);
        result.put("Ball", ballValue);

        assertThat(Game.currentScore(result)).isEqualTo(expected);
    }

}