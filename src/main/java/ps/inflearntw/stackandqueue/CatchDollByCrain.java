package ps.inflearntw.stackandqueue;

import java.util.Stack;

public class CatchDollByCrain {
    public static final int EMPTY = 0;
    public static final int CRASHED_DOLL_COUNT = 2;
    private final int[][] boards;
    private final int[] moves;
    private Stack<Integer> basket = new Stack<>();
    private int answer;

    public CatchDollByCrain(int[][] boards, int[] moves) {
        this.boards = boards;
        this.moves = moves;
    }

    public Integer play() {
        for (int catchPoint : moves) {
            int doll = -1;
            for (int i = 0; i < basket[catchPoint - 1].length; i++) {
                if (basket[catchPoint - 1][i] != 0) {
                    doll = basket[catchPoint - 1][i];
                    basket[catchPoint - 1][i] = 0;
                    break;
                }
            }

            if (doll != -1) {
                if (!caughts.isEmpty() && caughts.peek() == doll) {
                    answer += 2;
                    caughts.pop();
                } else {
                    caughts.push(doll);
                }
            }
        }

        return answer;
    }
}
