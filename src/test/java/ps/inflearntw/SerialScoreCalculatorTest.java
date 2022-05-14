package ps.inflearntw;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SerialScoreCalculatorTest {

    @Test
    public void initializeScore(){
        // given
        int[] scores = new int[]{1, 0, 1, 1, 1, 0, 0, 1, 1, 0};
        SerialScoreCalculator cal = SerialScoreCalculator.from(scores);

        // when
        int score = cal.calculateTotalScore();

        // then
        assertThat(score).isEqualTo(10);
    }
}
