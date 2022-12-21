package ps.inflearntw.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class GetCombination {

    private List<int[]> answer = new ArrayList<int[]>();
    private boolean[] checker;
    private int maxCount;
    private int marbleNum;

    /**
     * 1부터 N까지 번호가 적힌 구슬이 있다. 이 중 M개를 뽑는 방법의 수는?
     */

    public List<int[]> find(int marbleNum, int maxCount) {
        // 초기화
        this.marbleNum = marbleNum;
        this.maxCount = maxCount;
        this.checker = new boolean[marbleNum+1];

        // 전체 구슬의 개수를 돌며 조합을 선택
        for (int i = 1; i <= marbleNum; i++) {

            // 조합을 담기 위한 배열 선언
            int[] combination = new int[maxCount];

            // 첫 번째 구슬 삽입
            combination[0] = i;
            checker[i] = true;

            // 이 후 maxCount까지 가능한 조합을 선택
            DFS(combination, 1);
        }

        return answer;
    }

    private void DFS(int[] combination, int count) {
        // M개에 도달하면 정답에 조합을 삽입
        if(count == maxCount){
            answer.add(combination.clone());
        } else {
            // 도달 전까지는 구슬의 경우의 수를 순회 탐색하며
            for (int i = 1; i <= marbleNum; i++) {
                // 사용되지 않은 것들에 대해
                if(checker[i] == false){
                    // 구슬 번호를 추가해주고
                    combination[count] = i;

                    // 다음 구슬로 DFS
                    DFS(combination, count+1);
                }
            }
        }
    }
}
