package ps.inflearntw;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReversePrimeNumberTest {

    @Test
    public void testReverse(){
        // given
        int[] numbers = new int[]{32, 55, 62, 20, 250, 370, 200, 30, 100};
        ReversePrimeNumber reversePrimeNumber = ReversePrimeNumber.from(numbers);

        // when
        List<Integer> answer = reversePrimeNumber.findPrimeNumber();

        // then
        assertThat(answer).containsExactly(23, 2, 73, 2, 3);
    }
}
