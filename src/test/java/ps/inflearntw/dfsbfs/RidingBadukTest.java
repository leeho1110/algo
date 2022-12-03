package ps.inflearntw.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RidingBadukTest {

    @Test
    public void test(){
        // given
        RidingBaduk sut = new RidingBaduk();
        int[] weights = {81, 58, 42, 33, 61};

        // when
        int result = sut.findMaxWeight(weights);

        // then
        assertEquals(242, result);
    }

}