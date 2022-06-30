package ps.inflearntw.hashmap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KthLargestNumberTest {

    //10 3
    //13 15 34 23 45 65 33 11 26 42

    @Test
    public void integration(){
        // given
        KthLargestNumber sut = new KthLargestNumber();

        // when
        Integer result = sut.find(new int[]{13, 15, 34, 23, 45, 65, 33, 11, 26, 42}, 3);

        // then
        assertThat(result).isEqualTo(143);
    }
}