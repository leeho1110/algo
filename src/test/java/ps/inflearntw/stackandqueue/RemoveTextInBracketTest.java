package ps.inflearntw.stackandqueue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RemoveTextInBracketTest {

    // 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
    // (A(BC)D)EF(G(H)(IJ)K)LM(N) -> EFLM

    @Test
    public void test(){
        // given
        RemoveTextInBracket sut = new RemoveTextInBracket("(A(BC)D)EF(G(H)(IJ)K)LM(N)");

        // when
        String result = sut.extractNotInBracket();

        // then
        assertThat(result).isEqualTo("EFLM");
    }

}