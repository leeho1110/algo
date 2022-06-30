package ps.inflearntw.stackandqueue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RightBracketTest {

    @Test
    public void test(){
        // given
        RightBracket sut = new RightBracket("(()(()))(()");

        // when
        String result = sut.validate();

        // then
        assertThat(result).isEqualTo("NO");
    }

    @Test
    public void test2(){
        // given
        RightBracket sut = new RightBracket("(())()");

        // when
        String result = sut.validate();

        // then
        assertThat(result).isEqualTo("YES");
    }

}