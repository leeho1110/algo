package ps.inflearntw.dfsbfs;

public class Combination {

    public int combinationNoMemo(int entire, int select) {
        if (entire == select || select == 0) {
            return 1;
        } else {
            return combinationNoMemo(entire - 1, select - 1) + combinationNoMemo(entire - 1, select);
        }
    }
}
