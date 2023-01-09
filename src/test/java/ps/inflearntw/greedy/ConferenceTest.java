package ps.inflearntw.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ConferenceTest {

    @Test
    public void test(){
        // given
        Conference sut = new Conference();

        // when
        int result = sut.findMax(Arrays.asList(
                new Conference.ConferenceTime(1,4),
                new Conference.ConferenceTime(2,3),
                new Conference.ConferenceTime(3,5),
                new Conference.ConferenceTime(4,6),
                new Conference.ConferenceTime(5,7)
        ));

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void test2(){
        // given
        Conference sut = new Conference();

        // when
        int result = sut.findMax(Arrays.asList(
                new Conference.ConferenceTime(3,3),
                new Conference.ConferenceTime(1,3),
                new Conference.ConferenceTime(2,3)
        ));

        // then
        assertThat(result).isEqualTo(2);
    }

}