package ps.inflearntw.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicateCheckTest {

    @Test
    public void test(){
        // given
        int[] numbers = {20, 25, 52, 30, 39, 33, 43, 33};
        DuplicateCheck sut = new DuplicateCheck(numbers);

        // when
        String result = sut.validate();

        // then
        assertThat(result).isEqualTo("D");
    }

}