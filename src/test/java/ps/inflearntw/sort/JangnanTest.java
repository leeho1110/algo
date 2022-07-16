package ps.inflearntw.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JangnanTest {

    @Test
    public void test(){
        // given
        int[] students = {120, 125, 152, 130, 135, 135, 143, 127, 160};
        Jangnan sut = new Jangnan(students);

        // when
        int[] result = sut.find();

        // then
        assertThat(result).containsExactly(3,8);
    }
}