package ps.inflearntw.twopointer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SumOfSerialNaturalNumTest {

    /*
    N 입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
    만약 N=15이면 7+8=15, 4+5+6=15, 1+2+3+4+5=15 와 같이 총 3가지의 경우가 존재한다.

    첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
     */
    @Test
    public void integration(){
        // given
        SumOfSerialNaturalNum sut = new SumOfSerialNaturalNum(15);

        // when
        int result = sut.findAvailableCase();

        // then
        assertThat(result).isEqualTo(3);
    }
}