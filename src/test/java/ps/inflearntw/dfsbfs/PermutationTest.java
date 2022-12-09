package ps.inflearntw.dfsbfs;

import org.junit.jupiter.api.Test;

import java.util.List;


class PermutationTest {

    @Test
    public void test() {
        // given
        Permutation sut = new Permutation();

        // when
        List<int[]> result = sut.find(new int[]{3, 6, 9}, 2);

        // then
        for (int[] ints : result) {
            for (int number : ints) {
                System.out.print(number + " ");
            }
            System.out.println("\n");
        }

    }

}