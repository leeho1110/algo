package ps.inflearntw.recursion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrintBinaryTest {

    /**
     * 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요.
     * 첫 번째 줄에 10진수 N(1<=N<=1,000)이 주어집니다.
     *
     * 입력 예제
     * 11
     *
     * 출력 예제
     * 1011
     */

    @Test
    public void test(){
        // given
        PrintBinary sut = new PrintBinary(11);

        // when
        String resultBinary = sut.printToBinary();

        // then
        assertThat(resultBinary).isEqualTo("1011");
    }

    @Test
    public void test1(){
        // given
        PrintBinary sut = new PrintBinary(38791);

        // when
        String resultBinary = sut.printToBinary();

        // then
        assertThat(resultBinary).isEqualTo("1001011110000111");
    }
}