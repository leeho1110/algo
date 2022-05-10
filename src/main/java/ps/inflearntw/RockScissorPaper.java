package ps.inflearntw;

import java.util.ArrayList;
import java.util.List;

public class RockScissorPaper {

    public static final String DRAW = "D";
    public static final String WINNER_IS_A = "A";
    private static final String WINNER_IS_B = "B";
    private int[] caseOfA;
    private int[] caseOfB;
    private List<String> result = new ArrayList<>();
    public RockScissorPaper(int[] caseOfA, int[] caseOfB) {
        this.caseOfA = caseOfA;
        this.caseOfB = caseOfB;
    }

    public static RockScissorPaper GameReady(int[] caseOfA, int[] caseOfB){
        return new RockScissorPaper(caseOfA, caseOfB);
    }

    public List<String> playGame(){
        for(int i=0; i<caseOfA.length; i++){
            checkWinner(i);
        }

        return result;
    }

    private void checkWinner(int idx) {
        // A가 이기면 A, B가 이기면 B, 비기면 D
        // 가위 1, 바위 2, 보 3
        // 1은 3을 이기고, 2는 1을 이기고, 3은 2를 이김
        if(isDraw(caseOfA, idx, caseOfB[idx])){
            addAnswer(DRAW);
        } else if(checkWinner(idx, 1, 3)){
            addAnswer(WINNER_IS_A);
        } else if(checkWinner(idx, 2, 1)){
            addAnswer(WINNER_IS_A);
        } else if(checkWinner(idx, 3, 2)){
            addAnswer(WINNER_IS_A);
        } else {
            addAnswer(WINNER_IS_B);
        }
    }

    private void addAnswer(String winner) {
        result.add(winner);
    }

    private boolean isDraw(int[] caseOfA, int idx, int caseOfB) {
        return caseOfA[idx] == caseOfB;
    }

    private boolean checkWinner(int idx, int x, int x1) {
        return caseOfA[idx] == x && caseOfB[idx] == x1;
    }
}
