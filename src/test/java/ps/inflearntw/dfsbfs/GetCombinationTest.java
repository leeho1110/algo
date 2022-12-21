package ps.inflearntw.dfsbfs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GetCombinationTest {

    @Test
    public void test(){
        // given
        GetCombination sut = new GetCombination();

        // when
        List<int[]> result = sut.find(4, 2);

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}