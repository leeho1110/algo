package ps.inflearntw.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class DuplicatedPermutation {
    private final int endNumber;
    private final int count;
    private List<int[]> answer = new ArrayList<>();

    public DuplicatedPermutation(int endNumber, int count) {
        this.endNumber = endNumber;
        this.count = count;
    }

    public List<int[]> findAllCase() {
        // 전체 자연수에 대해 순회 탐색을 실시한다.
        for (int i = 1; i <= endNumber; i++) {
            // 중복 순열의 첫번째에는 첫 시작 자연수를 넣어준다.
            int[] permutation = new int[count];
            permutation[0] = i;

            // 나머지 자연수를 순회하면서 중복되어 추가되도록 DFS
            DFS(permutation, 1);
        }
        return answer;
    }

    private void DFS(int[] permutation, int count) {
        // 만약 정해진 길이가 완료되면 정답 배열에 추가
        if (count == this.count) {
            // answer에는 값을 계속 더해줄 permutation 배열을 넣어선 안된다.
            // 참조형이기에 answer에 들어간 원본이 변하지 않도록 깊은 복사를 마친 새로운 배열을 넣어준다.
            answer.add(permutation.clone());
        } else {
            // 정해진 길이가 다 되지 않았다면 남은 길이를 채울 때까지 자연수를 반복해서 넣어준다.
            for (int i = 1; i <= this.endNumber; i++) {
                // DFS
                permutation[count++] = i;
                DFS(permutation, count);
                count--;
            }
        }
    }
}