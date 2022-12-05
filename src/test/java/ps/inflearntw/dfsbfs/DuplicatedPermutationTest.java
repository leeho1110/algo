package ps.inflearntw.dfsbfs;

import org.junit.jupiter.api.Test;

import java.util.List;

class DuplicatedPermutationTest {

    @Test
    public void test() {
        // given
        DuplicatedPermutation sut = new DuplicatedPermutation(5, 3);

        // when
        List<int[]> result = sut.findAllCase();

        // then
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}