package ps.inflearntw.dfsbfs;

public class Combination {

    private int[][] memo = new int[0][0];

    public int findWithMemoization(int entire, int select) {
        this.memo = new int[entire + 1][entire + 1];
        return combination(entire, select);
    }

    public int combination(int entire, int select) {
        if (memo[entire][select] > 0) {
            return memo[entire][select];
        }

        if (entire == select || select == 0) {
            return 1;
        } else {
            return memo[entire][select] = combination(entire - 1, select - 1) + combination(entire - 1, select);
        }
    }

    public int combinationNoMemo(int entire, int select) {
        if (entire == select || select == 0) {
            return 1;
        } else {
            return combinationNoMemo(entire - 1, select - 1) + combinationNoMemo(entire - 1, select);
        }
    }
}
