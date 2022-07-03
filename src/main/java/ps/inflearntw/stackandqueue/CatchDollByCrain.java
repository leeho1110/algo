package ps.inflearntw.stackandqueue;

import java.util.Scanner;
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

    /*
    TODO
      setup: 정사각형으로 이뤄져 있고, N의 크기를 갖는 배열 선언하기, 크레인의 작동 순서가 담긴 배열의 크기, moves 배열 데이터
      #1. moves 배열의 값을 하나씩 돈다
            #1.1. 긴 한
      #2. 값이 있다면 정답 스택에 값을 비교한다.
            #2.1 peek()을 진행해서 값이 동일하면 넣지 않고, top 제거
            #2.2 만약 동일 하지 않다면 push
    */

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
