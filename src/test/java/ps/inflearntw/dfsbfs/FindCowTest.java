package ps.inflearntw.dfsbfs;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindCowTest {

    @Test
    public void tests(){
        // given
        FindCow sut = new FindCow(5);

        // when
        int result = sut.findShortest(14, new int[]{1,-1,5});

        // then
        assertThat(result).isEqualTo(3);
    }

}