package ps.inflearntw.stackandqueue;

import java.util.Stack;

public class CatchDollByCrain {
    private final int[][] basket;
    private final int[] moves;
    private Stack<Integer> caughts = new Stack<>();
    private int answer;

    public CatchDollByCrain(int[][] basket, int[] moves) {
        this.basket = basket;
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
