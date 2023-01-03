package ps.inflearntw.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TomatoTest {

    @Test
    public void normalCase() {
        // given
        Tomato sut = new Tomato();

        int[][] tomatos = {
                {0, 0, -1,  0,  0, 0},
                {0, 0,  1,  0, -1, 0},
                {0, 0, -1,  0,  0, 0},
                {0, 0,  0,  0, -1, 1}};

        // when
        int result = sut.getMinDate(tomatos);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void unripenedTomatoIsExist() {
        // given
        Tomato sut = new Tomato();

        int[][] tomatos = {
                {0, 0, -1,  0,  0, 0},
                {0, 0,  1,  0, -1, 0},
                {-1, 0, -1,  0,  0, 0},
                {0, -1,  0,  0, -1, 1}};

        // when
        int result = sut.getMinDate(tomatos);

        // then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void alreadyAllRiped() {
        // given
        Tomato sut = new Tomato();

        int[][] tomatos = {
                {1, 1, -1,  1,  1, 1},
                {1, 1,  1,  1, -1, 1},
                {-1, 1, -1,  1,  1, 1},
                {1, -1,  1,  1, -1, 1}};

        // when
        int result = sut.getMinDate(tomatos);

        // then
        assertThat(result).isEqualTo(0);
    }
}