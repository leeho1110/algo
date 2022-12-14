package ps.inflearntw.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    private int[] numbers;
    private int count;

    private List<int[]> answer = new ArrayList<>();
    private boolean[] check;

    public List<int[]> find(int[] numbers, int count) {
        // 변수 초기화
        this.numbers = numbers;
        this.count = count;

        // 전체 숫자 순회 탐색
        for (int i = 0; i < numbers.length; i++) {
            // 순열 배열 및 체크 배열 초기화
            int[] permutation = new int[count];
            this.check = new boolean[numbers.length];

            // DFS
            DFS(permutation, 0);
        }

        return answer;
    }

    private void DFS(int[] permutation, int count) {
        if (count == this.count) {
            answer.add(permutation.clone());
        } else {
            // 숫자 배열을 탐색하며
            for (int i = 0; i < numbers.length; i++) {
                // 만약 사용되지 않았다면
                if(isNotUsed(i)){
                    // 값을 순열 조합에 추가하고
                    permutation[count] = numbers[i];

                    // 사용 표시를 해준다
                    checkUse(i, Usage.USED);

                    // 이어서 순열 조합을 탐색한다
                    DFS(permutation, count+1);

                    // 탐색 이후엔 사용 표시를 풀어준다.
                    checkUse(i, Usage.UNUSED);
                }
            }
        }
    }

    private void checkUse(int i, Usage usage) {
        check[i] = usage.value;
    }

    private boolean isNotUsed(int i) {
        return check[i] == false;
    }

    private enum Usage {
        USED(true), UNUSED(false);

        private final boolean value;

        Usage(boolean value) {
            this.value = value;
        }
    }
}
