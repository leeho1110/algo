package ps.inflearntw.recursion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciTest {

    /**
     * # 재귀 함수를 통해 팩토리얼을 구현하기
     * 만약 7이 입력되면 1 1 2 3 5 8 13
     * 항수는 최소 3부터 45까지다.
     */

    @Test
    public void testFindV1(){ // 4.5sec
        // given
        Fibonacci sut = new Fibonacci();

        // when
        int result = sut.findV1(45);

        // then
        assertThat(result).isEqualTo(1134903170);
    }

    @Test
    public void testFindV2(){
        // given
        Fibonacci sut = new Fibonacci();

        // when
        int result = sut.findV2(45);

        // then
        assertThat(result).isEqualTo(1134903170);
    }

}