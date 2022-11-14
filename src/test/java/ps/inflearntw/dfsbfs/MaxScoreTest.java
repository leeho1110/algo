package ps.inflearntw.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxScoreTest {

    @Test
    public void test(){
        // given
        MaxScore sut = new MaxScore(new int[]{10,25,15,6,7}, new int[]{5,12,8,3,4}, 20);

        // when
        int result = sut.findMaxScore();

        // then
        assertEquals(result, 41);
    }

}