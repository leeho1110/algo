package ps.inflearntw.greedy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SsirmTest {

    @Test
    void findMax() {
        // given:
        int[][] members = {{172,67},{183,65},{180,70},{170,72},{181,60}};
        Ssirm sut = new Ssirm();

        // when:
        int result = sut.findMax(members);

        // then:
        assertThat(result).isEqualTo(3);
    }
}