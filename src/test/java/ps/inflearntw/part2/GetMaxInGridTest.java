package ps.inflearntw.part2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class GetMaxInGridTest {

    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Test
    public void test_getMaxOnGridTest() {
        // given
        int[][] grid = new int[5][5];
        grid[0] = new int[]{10, 13, 10, 12,15};
        grid[1] = new int[]{12, 39, 30, 23,11};
        grid[2] = new int[]{11, 25, 50, 53,15};
        grid[3] = new int[]{19, 27, 29, 37,27};
        grid[4] = new int[]{19, 13, 30, 13,19};

        GetMaxInGrid getMaxInGrid = new GetMaxInGrid(grid);

        // when
        int maxValue = getMaxInGrid.getMaxValue();

        // then
        assertThat(maxValue).isEqualTo(155);
    }
}
