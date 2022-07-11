package ps.inflearntw.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SelectedSortTest {

    @Test
    public void test(){
        // given
        int[] numbers = {13, 5, 11, 7, 23, 15};
        SelectedSort sut = new SelectedSort(numbers);

        // when
        int[] result = sut.sort();

        // then
        assertThat(result).containsExactly(5,7,11,13,15,23);
    }

}