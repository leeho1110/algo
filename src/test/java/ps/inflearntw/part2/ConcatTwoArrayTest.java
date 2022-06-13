package ps.inflearntw.part2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConcatTwoArrayTest {

    // 오름차순으로 정렬이 된 두 배열이 주어지면, 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

    // 첫 번째 줄에 첫 번째 배열의 크기
    // 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어진다.
    // 세 번째 줄에 두 번째 배열의 크기
    // 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어진다.

    @Test
    public void test_getSystemInput(){
        // given
        int[] stub = new int[]{1,2,3,3,5,6,7,9};
        ConcatTwoArray sut = ConcatTwoArray.of(new int[]{1,3,5}, new int[]{2,3,6,7,9});

        // when
        int[] result = sut.sorting();

        // then
        assertThat(result).containsExactly(stub);
    }
}
