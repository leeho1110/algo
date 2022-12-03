package ps.inflearntw.dfsbfs;

public class RidingBaduk {
    private int answer;
    private int[] weights;

    public int findMaxWeight(int[] weights) {
        this.weights = weights;

        DFS(0,0);

        return answer;
    }

    private void DFS(int idx, int sum) {
        // 최대 무개가 넘으면 뒤로 Back
        if(sum > 259){
            return;
        }

        // weights.length(5)로 지정한 이유
        // -> 만약 하나 작게 지정하게 되면 배열의 마지막에 접근할 때 sum을 하지 않고 바로 answer를 측정해버림
        if(idx == weights.length){
            answer = Math.max(sum, answer);
        } else {
            DFS(idx+1, sum + weights[idx]);
            DFS(idx+1, sum);
        }
    }

    /**
     * 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
     * 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
     * N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
     */

}
