package ps.inflearntw;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingGetterTest {

    @Test
    public void integration(){
        // given
        int[] scores = new int[]{87, 89, 92, 100, 76};
        RankingGetter rankingGetter = RankingGetter.from(scores);

        // when
        List<Integer> rank = rankingGetter.lineUp();

        // then
        assertThat(rank).containsExactly(4,3,2,1,5);
    }
}
