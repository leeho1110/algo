package ps.inflearntw;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetHighInGridTest {

    @Test
    public void test_GetHighInGrid(){
        // given
        int[][] grid = new int[7][7];
        grid[1] = new int[]{0, 5, 3, 7, 2, 3, 0};
        grid[2] = new int[]{0, 3, 7, 1, 6, 1, 0};
        grid[3] = new int[]{0, 7, 2, 5, 3, 4, 0};
        grid[4] = new int[]{0, 4, 3, 6, 4, 1, 0};
        grid[5] = new int[]{0, 8, 7, 3, 5, 2, 0};
        GetHighInGrid getHighInGrid = new GetHighInGrid(grid);

        // when
        int countOfHigh = getHighInGrid.getHigh();

        // then
        assertThat(countOfHigh).isEqualTo(10);
    }
}
