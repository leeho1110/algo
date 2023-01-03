package ps.inflearntw.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class Tomato {

    private int answer = Integer.MIN_VALUE;

    private int[] xDirection = {0, 1, 0, -1};
    private int[] yDirection = {-1, 0, 1, 0};
    private int[][] tomatos;
    private int[][] checkDate;
    private Queue<int[]> ripedTomato = new LinkedList<>();

    public int getMinDate(int[][] tomatos) {
        this.tomatos = tomatos;
        this.checkDate = new int[tomatos.length][tomatos[0].length];

        // 1. 전달받은 배열 전체를 순회하며, 맨 처음 익은 토마토들을 찾는다.
        boolean isAllRipedAlready = true;
        for (int i = 0; i < tomatos.length; i++) {
            for (int j = 0; j < tomatos[0].length; j++) {
                // 이미 모두 익어있다면 항상 1 아니면 -1이 나올거다
                // 근데 0이 나오면 안익는게 있다는 뜻이니 저장 전 이미 모두 익어있는지에 대한 플래그를 변경한다.
                if(tomatos[i][j] == 0){
                    isAllRipedAlready = false;
                }

                if (tomatos[i][j] == 1) {
                    ripedTomato.add(new int[]{i, j});
                }
            }
        }

        // 이미 모두 익어있는 상태라면 모두 1일테니
        if(isAllRipedAlready) return 0;

        // 익은 토마토를 기준으로, 모든 토마토가 읽을 때까지 BFS를 진행한다.
        calculateMinumumRipingDate();

        // 토마토를 익히는 작업이 끝난 후, 아직 읽지 않은 토마토가 있는지 검사한다.
        for (int i = 0; i < tomatos.length; i++) {
            for (int j = 0; j < tomatos[0].length; j++) {
                if(tomatos[i][j] == 0){
                    return -1;
                }
            }
        }

        // 다 읽었다면 모두 읽을 때까지 걸린 시간을 추출
        for (int i = 0; i < checkDate.length; i++) {
            for (int j = 0; j < checkDate[0].length; j++) {
                answer = Math.max(answer, checkDate[i][j]);
            }
        }

        return answer;
    }

    /**
     * 1. 전달받은 배열 전체를 순회하며, 맨 처음 익은 토마토들을 찾는다.
     * 2. 찾은 익은 토마토에서 상하좌우를 검사하며, 범위에서 벗어나거나 안익은 토마토라면 익힌다.
     * 3. 익은 토마토를 익은 토마토들을 넣는 배열에 넣는다.
     * 4. 익힌 토마토는 자리에 지금 익은 토마토가 있는 자리에서 1을 더해준 값을 더해준다.
     * 왜냐면 익은 토마토가 있는 자리는 기존 토마토가 익기 위해 걸린 시간을 표현한거니까
     * 5. 다 끝나면 아직 안익은 토마토가 있는지 파악한다. 만약 그렇다면 -1을 반환한다.
     * 6. 모두가 익어있다면 하나도 1로 바뀌지 않을테니까 그냥 최대값을 반환하면 된다.
     */

    private void calculateMinumumRipingDate() {
        while (!ripedTomato.isEmpty()) {
            int[] ripeTomato = ripedTomato.poll();

            for (int i = 0; i < 4; i++) {
                int newYDirection = ripeTomato[0] + yDirection[i];
                int newXDirection = ripeTomato[1] + xDirection[i];

                // 2. 찾은 익은 토마토에서 상하좌우를 검사하며, 범위에서 벗어나거나 안익은 토마토라면 익힌다.
                if(newXDirection >= 0 && newXDirection < tomatos[0].length
                        && newYDirection >= 0 && newYDirection < tomatos.length
                        && tomatos[newYDirection][newXDirection] == 0){
                    // 3. 익은 토마토를 익은 토마토들을 넣는 배열에 넣는다.
                    ripedTomato.add(new int[]{newYDirection,newXDirection});

                    // 5. 안익은 토마토를 익었다고 표시한다.
                    tomatos[newYDirection][newXDirection] = 1;

                    // 4. 익힌 토마토는 자리에 지금 익은 토마토가 있는 자리에서 1을 더해준 값을 더해준다.
                    checkDate[newYDirection][newXDirection] += checkDate[ripeTomato[0]][ripeTomato[1]] + 1;
                }
            }
        }
    }
}
