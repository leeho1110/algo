package ps.inflearntw.stackandqueue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SavePrincessTest {

    @Test
    public void test(){
        // given
        SavePrincess sut = new SavePrincess(8);

        // when
        Integer result = sut.findLastPrince(3);

        // then
        assertThat(result).isEqualTo(7);
    }

}