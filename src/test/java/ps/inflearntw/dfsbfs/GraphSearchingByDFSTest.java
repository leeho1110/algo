package ps.inflearntw.dfsbfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GraphSearchingByDFSTest {

    @Test
    public void test(){
        // given
        int[][] graph = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
        };
        GraphSearchingByDFS sut = new GraphSearchingByDFS(graph);

        // when
        int result = sut.findAllCaseOf(5);

        // then
        assertThat(result).isEqualTo(6);

    }

}