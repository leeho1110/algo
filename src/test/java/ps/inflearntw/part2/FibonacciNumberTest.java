package ps.inflearntw.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciNumberTest {

    /*
    1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
    2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

    첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
    */

    @Test
    public void testStaticFactoryMethod(){
        // given
        int hang = 5;

        // when
        FibonacciNumber fibonacci = FibonacciNumber.from(hang);

        // then
        assertThat(fibonacci.getHang()).isEqualTo(hang);
        assertThat(fibonacci.getAnswer()).containsExactly(1,1,2);
    }

    @Test
    public void testCreateSequence_when_5(){
        // given
        int hang = 5;
        FibonacciNumber fibonacci = FibonacciNumber.from(hang);

        // when
        List<Integer> answer = fibonacci.createSequence();

        // then
        assertThat(answer).containsExactly(1,1,2,3,5);
    }

    @Test
    public void testCreateSequence_when_3(){
        // given
        int hang = 3;
        FibonacciNumber fibonacci = FibonacciNumber.from(hang);

        // when
        List<Integer> answer = fibonacci.createSequence();

        // then
        assertThat(answer).containsExactly(1,1,2);
    }
}
