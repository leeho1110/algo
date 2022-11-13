package ps.inflearntw.dfsbfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShortestDistanceByListTest {

    @Test
    public void test(){
        // given
        ShortestDistanceByList sut = new ShortestDistanceByList(Arrays.asList(
                Collections.emptyList(),
                Arrays.asList(3, 4),
                Arrays.asList(1, 5),
                Arrays.asList(4),
                Arrays.asList(5, 6),
                Collections.emptyList(),
                Arrays.asList(2, 5))
        );

        // when
        int result = sut.search(2);

        // then
        assertThat(result).isEqualTo(3);
    }
}