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
        for (int line : moves) {
            compareBasketsTopWith(caughtDollOfSpecificLineOfBasket(line));
        }
        return answer;
    }

    private int caughtDollOfSpecificLineOfBasket(int line) {
        for (int height = 0; height < boards[line - 1].length; height++) {
            int caughtDoll = boards[line - 1][height];
            if (isNotEmpty(caughtDoll)) {
                convertToEmptyOf(line, height);
                return caughtDoll;
            }
        }
        return EMPTY;
    }

    private boolean isNotEmpty(int caughtDoll) {
        return caughtDoll != EMPTY;
    }

    private void convertToEmptyOf(int point, int i) {
        boards[point - 1][i] = EMPTY;
    }

    private void compareBasketsTopWith(int caughtDoll) {
        if (isNotEmpty(caughtDoll)) {
            if (hasDollInBasket() && isEqualToTopOfBasket(caughtDoll)) {
                answer += CRASHED_DOLL_COUNT;
                basket.pop();
            } else {
                basket.push(caughtDoll);
            }
        }
    }

    private boolean isEqualToTopOfBasket(int caughtDoll) {
        return basket.peek() == caughtDoll;
    }

    private boolean hasDollInBasket() {
        return !basket.isEmpty();
    }
}
