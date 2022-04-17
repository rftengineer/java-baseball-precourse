package baseball.model.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumbersForGameGeneratorTest {

    @Test
    void Length_3_Of_NumbersForGameGenerator() {
        RandomGenerator generator = new NumbersForGameGenerator(1,9,3);
        String data = String.valueOf(generator.generate());
        assertThat(data.length()).isEqualTo(3);
    }
}