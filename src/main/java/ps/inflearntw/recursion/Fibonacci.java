package ps.inflearntw.recursion;

public class Fibonacci {

    private int[] fibos;

    public int findV1(int hang) {
        createListForMemoization(hang);
        if (hang == 1 || hang == 2) {
            return 1;
        } else {
            return findV1(hang - 2) + findV1(hang - 1);
        }
    }

    public int findV2(int hang) {
        createListForMemoization(hang);
        return DFS(hang);
    }

    private int DFS(int hang) {
        if(isAlreadyCaculated(hang)){
            return fibos[hang];
        }
        if (isUnderSecondHang(hang)) {
            return fibos[hang] = 1;
        } else {
            return fibos[hang] = DFS(hang - 2) + DFS(hang - 1);
        }
    }

    private boolean isAlreadyCaculated(int hang) {
        return fibos[hang] > 0;
    }

    private void createListForMemoization(int hang) {
        this.fibos = new int[hang + 1];
    }

    private boolean isUnderSecondHang(int hang) {
        return hang == 1 || hang == 2;
    }
}
