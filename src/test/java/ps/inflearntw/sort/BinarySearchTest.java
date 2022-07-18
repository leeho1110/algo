package ps.inflearntw.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTest {

    @Test
    public void test(){
        // given
        int target = 32;
        int[] numbers = {23, 87, 65, 12, 57, 32, 99, 81};

        BinarySearch sut = new BinarySearch(numbers);

        // when
        int result = sut.find(target);

        // then
        assertThat(result).isEqualTo(3);
    }

}