package algorithm.dfs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SubsetTest {

    @Test
    public void test(){
        // given
        Subset sut = new Subset();

        // when
        List<List<Integer>> result = sut.findSubset(3);

        // then
        assertThat(result).containsAnyOf(
                List.of(1,2,3),
                List.of(1,2),
                List.of(1,2),
                List.of(1),
                List.of(2,3),
                List.of(2),
                List.of(3)
        );
    }

}