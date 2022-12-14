package ps.inflearntw.dfsbfs;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;


class PermutationTest {

    @Test
    public void test() {
        // given
        Permutation sut = new Permutation();

        // when
        List<int[]> result = sut.find(new int[]{1, 2, 3, 4, 5}, 3);

        // then
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}