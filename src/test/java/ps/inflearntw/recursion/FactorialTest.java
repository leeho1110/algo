package ps.inflearntw.recursion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactorialTest {

    /**
     * # 재귀 함수를 통해 팩토리얼을 구현하기
     * 만약 7이 입력되면 1 1 2 3 5 8 13
     * 항수는 최소 3부터 45까지다.
     */

    @Test
    public void test(){
        // given
        Factorial sut = new Factorial();

        // when
        int result = sut.find(7);

        // then
        assertThat(result).isEqualTo(13);
    }

}