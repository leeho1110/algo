package ps.inflearntw.part2;

import java.util.ArrayList;
import java.util.List;

public class ConcatTwoArray {
    private int[] firstArray;
    private int[] secondArray;

    public ConcatTwoArray(int[] firstArray, int[] secondArray) {
       this.firstArray = firstArray;
       this.secondArray = secondArray;
    }

    public static ConcatTwoArray of(int[] firstArray, int[] secondArray) {
        return new ConcatTwoArray(firstArray, secondArray);
    }

    public int[] sorting() {
        List<Integer> answer = new ArrayList<>();
        int pointer1 = 0;
        int pointer2 = 0;

        while(pointer1 < firstArray.length && pointer2 < secondArray.length){
            if(firstArray[pointer1] < secondArray[pointer2]){
                answer.add(firstArray[pointer1++]);
            } else {
                answer.add(secondArray[pointer2++]);
            }
        }

        if(pointer1 != firstArray.length){
            for (int i = pointer1; i < firstArray.length; i++) {
                answer.add(firstArray[i]);
            }
        }

        if(pointer2 != secondArray.length){
            for (int i = pointer2; i < secondArray.length; i++) {
                answer.add(secondArray[i]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
