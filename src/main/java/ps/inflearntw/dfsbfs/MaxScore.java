package ps.inflearntw.dfsbfs;

public class MaxScore {

    private final int[] timeCosts;
    private final int[] scores;
    private final int timeLimit;
    private int answer;
    private boolean endFlag;

    public MaxScore(int[] scores, int[] timeCosts, int timeLimit) {
        this.scores = scores;
        this.timeCosts = timeCosts;
        this.timeLimit = timeLimit;
    }

    /**
     * 제공되는 N개의 문제 중 제한시간 내에 가장 많은 점수를 얻을 수 있는 점수를 구하라.
     * <p>
     * Node가 뻗어나가면서 변경되는 것은 점수와 제한시간입니다.
     * {(10,5), (25,12), (15,8), (6,3), (7,4)}
     * DFS(문제, 점수, 제한시간)
     * DFS(0,0,0)
     * /                                   \
     * DFS(1,10,5)                         DFS(1,0,0)
     * /               \                   /               \
     * DFS(2,25,17)    DFS(2,10,5)         DFS(2,25,12)    DFS(2,0,0)
     */

    public int findMaxScore() {
        DFS(0, 0, 0);
        return answer;
    }

    private void DFS(int problem, int score, int timeCost) {
        if(timeCost > timeLimit){
            return;
        }

        if (endFlag) {
            return;
        }

        if (timeCost == 20) {
                answer = score;
                endFlag = true;
        } else {
            DFS(problem + 1, score + scores[problem], timeCost + timeCosts[problem]);
            DFS(problem + 1, score, timeCost);
        }
    }
}
