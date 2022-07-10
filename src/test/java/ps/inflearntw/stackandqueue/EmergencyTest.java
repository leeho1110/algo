package ps.inflearntw.stackandqueue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmergencyTest {

    @Test
    public void test1(){
        // given
        int[] patients = new int[]{60,50,70,80,90};
        Emergency sut = new Emergency(patients);

        // when
        Integer result = sut.takeCare(2);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void test2(){
        // given
        int[] patients = new int[]{70,60,90,60,60,60};
        Emergency sut = new Emergency(patients);

        // when
        Integer result = sut.takeCare(3);

        // then
        assertThat(result).isEqualTo(4);
    }

}