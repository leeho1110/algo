package ps.inflearntw.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CacheLeastRecentlyUsedTest {

    @Test
    public void test(){
        // given
        int[] tasks = {1, 2, 3, 2, 6, 2, 3, 5, 7};
        CacheLeastRecentlyUsed sut = new CacheLeastRecentlyUsed(tasks, 5);

        // when
        int[] result = sut.printHistory();

        // then
        assertThat(result).containsExactly(7,5,3,2,6);
    }
}