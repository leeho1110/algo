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
        DFS(0,0);
        return answer;
    }

    private void DFS(int element, int sum) {
        if(endFlag){
            return;
        }

        if(sum > totalSum/2){
            return;
        }

        if(element == subset.length){
            if((totalSum-sum) == sum){
                answer = "YES";
                endFlag = true;
            }
        } else {
            DFS(element+1, sum+subset[element]);
            DFS(element+1, sum);
        }
    }
}
