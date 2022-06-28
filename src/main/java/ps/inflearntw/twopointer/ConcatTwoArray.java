package ps.inflearntw.twopointer;

import java.util.LinkedList;
import java.util.List;

public class ConcatTwoArray {

    private final int[] array1, array2;
    private final List<Integer> answer = new LinkedList<>();
    private Integer leftPtr = 0;
    private Integer rightPtr = 0;

    public ConcatTwoArray(int[] array1, int[] array2) {
        this.array2 = array2;
        this.array1 = array1;
    }

    public static ConcatTwoArray of(int[] array1, int[] array2) {
        return new ConcatTwoArray(array1, array2);
    }

    public int[] concat() {
        findUntilRightPointerIsEqualToAnyArray();
        addValueOfRemainArrayToAnswer();
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void addValueOfRemainArrayToAnswer() {
        if(leftPtr == array1.length){
            for(int i = rightPtr; i< array2.length; i++){
                answer.add(array2[i]);
            }
        }

        if(rightPtr == array2.length){
            for(int i = leftPtr; i< array1.length; i++){
                answer.add(array1[i]);
            }
        }
    }

    private void findUntilRightPointerIsEqualToAnyArray() {
        while(leftPtr < array1.length && rightPtr < array2.length){
            if(array1[leftPtr] > array2[rightPtr]){
                answer.add(array2[rightPtr]);
                rightPtr++;
            } else {
                answer.add(array1[leftPtr]);
                leftPtr++;
            }
        }
    }
}
