package ps.inflearntw.part2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNumberCalculatorTest {

    @Test
    public void getPrimeNumber(){
        // given
        PrimeNumberCalculator cal = PrimeNumberCalculator.from(20);

        // when
        int answer = cal.findPrimeNumber();

        // then
        assertThat(answer).isEqualTo(8);
    }
}
