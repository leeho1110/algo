package ps.inflearntw.dfsbfs;


import java.util.Arrays;

/**
 * N개의 원소로 구성된 자연수 집합을 두 개로 나눠 둘의 합이 같은 경우가 존재하면 YES 아니라면 NO를 출력하라
 *
 *
 * {1,3,5,6,7,10} : {1,3,5,7} = {6,10} -> TRUE
 */
public class SumEqualSubSet {

    private static final String YES = "YES";
    private static final String NO = "NO";

    private final int[] subset;
    private final int totalSum;
    private String answer = "NO";
    private boolean endFlag;

    public SumEqualSubSet(int[] subset) {
        this.subset = subset;
        this.totalSum = Arrays.stream(subset).sum();
    }

    public String findCase() {
        /**
         * DFS(0,0)으로 시작해서 부분집합의 끝 DFS(6,X)에 도달할 때까지 계속 탐색을 수행합니다.
         *
         * 그 중에서 부분집합을 더할 것인지 아닌지를 선택할 수 있습니다.
         * 이는 다음 노드에 넘길 sum값의 변화에 따라 달라집니다.
         *                              D(0,0)
         *                  /                            \
         *               D(1,1)                         D(1,0)
         *          /             \                 /          \
         *      D(2,4)          D(2,1)          D(2,3)        D(2,0)
         *     /    \           /    \          /     \        /    \
         * D(3,9)   D(3,4)   D(3,6) D(3,1)  D(3,8)  D(3,3)  D(3,5)  D(3,0)
         */
        DFS(0, 0);
        return answer;
    }

    private void DFS(int element, int sum) {
        if(endFlag){
            return;
        }

        // total에서 절반을 뺀 것보다 부분집합들의 합(sum)이 크면 이미 조건에 부적합하니 연산을 진행하지 않는다.
        if(sum > totalSum / 2){
            return;
        }

        // 부분집합 끝까지 돈 경우
        if (element == subset.length) {
            // total에서 지금까지 더한 값(sum)을 빼고 값이 같은지 확인합니다.
            if ((totalSum - sum) == sum) {
                // 만약 같다면 "YES"를 반환합니다.
                answer = "YES";
                // 하지만 만약 가장 빠른 타이밍에 YES로 변경되면 이후 수행되는 DFS는 모두 연산 낭비, 이를 방지하기 위한 flag
                endFlag = true;
            }
        } else { // 아직 끝까지 돌지 않았다면 부분집합을 완성시키기 위해 다음 요소를 호출합니다.

            // 부분요소를 더하고 호출하는 경우
            DFS(element + 1, sum + subset[element]);

            // 부분요소를 더하지 않고 호출하는 경우
            DFS(element + 1, sum);
        }
    }
}
