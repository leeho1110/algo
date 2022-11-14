package ps.inflearntw.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SumEqualSubSetTest {

    @Test
    public void test(){
        // given
        SumEqualSubSet sut = new SumEqualSubSet(new int[]{1, 3, 5, 6, 7, 10});

        // when
        String result = sut.findCase();

        // then
        assertEquals("YES", result);
    }

}