package ps.inflearntw;

public class GetMaxInGrid {

    private int[][] grid;
    private int maxValue = Integer.MIN_VALUE;
    public GetMaxInGrid(int[][] grid) {
        setGrid(grid);
    }

    private void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int getMaxValue() {
        checkHorizontalAndVertical();
        checkLeftDiagonal();
        checkRightDiagonal();

        return maxValue;
    }

    private void checkLeftDiagonal() {
        int leftDiagonal = 0;
        for(int i=0; i<grid.length; i++){
            leftDiagonal+= grid[i][i];
        }
        changeMaxIfBiggerThan(leftDiagonal);
    }

    private void checkRightDiagonal() {
        int rightDiagonal = 0;
        for(int i=grid.length-1; i>=0; i--){
            rightDiagonal+= grid[i][i];
        }
        changeMaxIfBiggerThan(rightDiagonal);
    }

    private void checkHorizontalAndVertical() {
        for(int i=0; i<grid.length; i++){
            int horizontal = Integer.MIN_VALUE;
            int vertical = Integer.MIN_VALUE;

            for(int j=0; j<grid.length; j++){
                horizontal += grid[i][j];
                vertical += grid[j][i];
            }

            changeMaxIfBiggerThan(horizontal);
            changeMaxIfBiggerThan(vertical);
        }
    }

    private void changeMaxIfBiggerThan(int sum) {
        if(isBiggerThanMaxValue(sum)){
            changeMaxValue(sum);
        }
    }



    private void changeMaxValue(int sum) {
        maxValue = sum;
    }

    private boolean isBiggerThanMaxValue(int sum) {
        return sum > maxValue;
    }
}
