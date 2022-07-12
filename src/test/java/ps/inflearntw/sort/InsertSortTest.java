package ps.inflearntw.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InsertSortTest {

    @Test
    public void test(){
        // given
        int[] numbers = {11, 7, 5, 6, 10, 9};
        InsertSort sut = new InsertSort(numbers);

        // when
        int[] result = sut.sort();

        // then
        assertThat(result).containsExactly(5,6,7,9,10,11);
    }

}