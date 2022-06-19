package ps.inflearntw.twopointer;

import java.util.ArrayList;
import java.util.List;

public class ConcatTwoArray {
    private List<Integer> ANSWER = new ArrayList<>();

    private int pointer1 = 0;
    private int pointer2 = 0;
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
        addSmallerValueByPointer();
        addLeftovers();
        return ANSWER.stream().mapToInt(Integer::intValue).toArray();
    }

    private void addSmallerValueByPointer() {
        while(untilSmallerThanArrayLength(pointer1, pointer2)){
            if(isSmallerThan(pointer1, pointer2)){
                ANSWER.add(firstArray[pointer1++]);
            } else {
                ANSWER.add(secondArray[pointer2++]);
            }
        }
    }

    private boolean untilSmallerThanArrayLength(int pointer1, int pointer2) {
        return pointer1 < firstArray.length && pointer2 < secondArray.length;
    }

    private boolean isSmallerThan(int pointer1, int pointer2) {
        return firstArray[pointer1] < secondArray[pointer2];
    }

    private void addLeftovers() {
        if(isDifferentWith(pointer1, firstArray.length)){
            for (int i = pointer1; i < firstArray.length; i++) {
                ANSWER.add(firstArray[i]);
            }
        }

        if(isDifferentWith(pointer2, secondArray.length)){
            for (int i = pointer2; i < secondArray.length; i++) {
                ANSWER.add(secondArray[i]);
            }
        }
    }

    private boolean isDifferentWith(int pointer, int arrayLenth) {
        return pointer != arrayLenth;
    }
}
