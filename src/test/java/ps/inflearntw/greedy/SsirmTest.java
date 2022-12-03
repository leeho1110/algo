package ps.inflearntw.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SsirmTest {

    @Test
    void findMax() {
        // given:
        Ssirm sut = new Ssirm();

        // when:
        int result = sut.findMax(Arrays.asList(
            new Ssirm.Body(172,67),
            new Ssirm.Body(183,65),
            new Ssirm.Body(180,70),
            new Ssirm.Body(170,72),
            new Ssirm.Body(181,60)
        ));

        // then:
        assertThat(result).isEqualTo(3);
    }
}