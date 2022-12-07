package ps.inflearntw.dfsbfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ExchangeCoinTest {

    @Test
    public void test(){
        // given
        ExchangeCoin sut = new ExchangeCoin();

        // when
        int result = sut.findMinimumAmount(Arrays.asList(1,2,5),15);

        // then
        assertThat(result).isEqualTo(3);
    }
}