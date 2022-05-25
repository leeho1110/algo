package ps.inflearntw;

public class GetHighInGrid {

    private int[][] grid;
    private int high;

    public GetHighInGrid(int[][] grid) {
        setGrid(grid);
    }

    private void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int getHigh() {
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid.length - 1; j++) {
                if (isHigh(i, j)) {
                    addHighCount();
                }
            }
        }

        return high;
    }

    private void addHighCount() {
        high++;
    }

    private boolean isHigh(int i, int j) {
        return isBiggerThanUp(i, j) &&
                ifBiggerThatDown(i, j) &&
                isBiggerThanLeft(i, j) &&
                isBiggerThanRight(i, j);
    }

    private boolean isBiggerThanRight(int i, int j) {
        return grid[i][j] > grid[i][j + 1];
    }

    private boolean isBiggerThanLeft(int i, int j) {
        return grid[i][j] > grid[i][j - 1];
    }

    private boolean ifBiggerThatDown(int i, int j) {
        return grid[i][j] > grid[i + 1][j];
    }

    private boolean isBiggerThanUp(int i, int j) {
        return grid[i][j] > grid[i - 1][j];
    }
}
