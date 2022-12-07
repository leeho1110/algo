package ps.inflearntw.dfsbfs;

import java.util.List;

public class ExchangeCoin {
    private List<Integer> coins;
    private int answer = Integer.MAX_VALUE;
    private int change;

    public int findMinimumAmount(List<Integer> coins, int change) {
        this.coins = coins;
        this.change = change;

        // DFS 탐색
        DFS(0, 0);

        return answer;
    }

    private void DFS(int usedCoinAmout, int sum) {
        // 위 로직을 누락하면 잔돈과 일치하는 경우에만 answer을 기록하여 DFS가 무한으로 돌아 StackOverFlow가 발생한다.
        if(sum > change){
            return;
        }

        // 잔돈과 지금까지 사용한 동전의 합계가 동일한 경우
        if(sum == change){
            // 더 적은 횟수로 변경
            answer = Math.min(answer, usedCoinAmout);
        } else {
            // 제공된 동전을 돌며 값을 더해준다.
            for (Integer coin : coins) {
                DFS(usedCoinAmout+1, sum + coin);
            }
        }
    }
}
