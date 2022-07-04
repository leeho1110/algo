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

            // 1. 큐에 최상단이 빈칸이라면, 빈칸이 아닐 때까지 꺼내기 (여기서 빈칸을 모두 비워)
            // peek()을 진행해서 값이 동일하면 넣지 않고, top 제거
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
