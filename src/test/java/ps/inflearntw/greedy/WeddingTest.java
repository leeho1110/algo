package ps.inflearntw.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WeddingTest {

    @Test
    public void test(){
        // given
        Wedding sut = new Wedding();

        // when
        int result = sut.findMax(Arrays.asList(
                new Wedding.Attending(14,18),
                new Wedding.Attending(12,15),
                new Wedding.Attending(15,20),
                new Wedding.Attending(20,30),
                new Wedding.Attending(5,14)
        ));

        // then
        assertEquals(result,2);

    }

}