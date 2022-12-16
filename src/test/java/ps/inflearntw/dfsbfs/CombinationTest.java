package ps.inflearntw.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationTest {

    @Test
    public void test(){
        // given
        Combination sut = new Combination();

        // when
        int result = sut.findWithMemoization(33, 19);

        // then
        assertEquals(result,818809200); // 99ms
    }

    @Test
    public void testNoMemoization(){
        // given
        Combination sut = new Combination();

        // when
        int result = sut.combinationNoMemo(33, 19);

        // then
        assertEquals(result,818809200); // 6.35 sec
    }
}