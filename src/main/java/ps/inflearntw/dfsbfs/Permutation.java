package ps.inflearntw.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    private int[] numbers;
    private int count;

    private List<int[]> answer = new ArrayList<>();

    public List<int[]> find(int[] numbers, int count) {
        this.numbers = numbers;
        this.count = count;

        for (int i = 0; i < numbers.length; i++) {
            int[] permutation = new int[count];
            permutation[0] = i;
            DFS(permutation, 1);
        }

        return answer;
    }

    private void DFS(int[] permutation, int count) {
        if (count == this.count) {
            answer.add(permutation.clone());
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (isNewNumber(permutation, numbers[i])) {
                    permutation[count++] = numbers[i];
                } else {
                    continue;
                }
                DFS(permutation, count + 1);
                count--;
            }
        }
    }

    private boolean isNewNumber(int[] permutation, int number) {
        for (int n : permutation) {
            if (n == number) {
                return false;
            }
        }
        return true;
    }
}
