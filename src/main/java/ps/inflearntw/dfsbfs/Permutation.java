package ps.inflearntw.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    private int[] numbers;
    private int count;

    private List<int[]> answer = new ArrayList<>();
    private boolean[] check;

    public List<int[]> find(int[] numbers, int count) {
        this.numbers = numbers;
        this.count = count;

        for (int i = 0; i < numbers.length; i++) {

            int[] permutation = new int[count];
            permutation[0] = numbers[i];

            this.check = new boolean[numbers.length];
            check[i] = true;

            DFS(permutation, 1);
        }

        return answer;
    }

    private void DFS(int[] permutation, int count) {
        if (count == this.count) {
            answer.add(permutation.clone());
        } else {
            for (int i = 0; i < check.length; i++) {
                if(isAlreadyUsed(i)){
                    permutation[count] = numbers[i];
                    checkUse(i, Usage.USE);

                    DFS(permutation, count+1);

                    checkUse(i, Usage.UNUSE);
                }
            }
        }
    }

    private void checkUse(int i, Usage usage) {
        check[i] = usage.value;
    }

    private boolean isAlreadyUsed(int i) {
        return check[i] == false;
    }

    enum Usage {USE(true), UNUSE(false);

        private final boolean value;

        Usage(boolean value) {
            this.value = value;
        }
    }
}
