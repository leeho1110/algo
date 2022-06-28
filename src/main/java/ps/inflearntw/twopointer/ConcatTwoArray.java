package ps.inflearntw.twopointer;

import java.util.LinkedList;
import java.util.List;

public class ConcatTwoArray {

    private List<Integer> answer = new LinkedList<>();

    public int[] concat(int[] array1, int[] array2) {
        int leftPtr = 0;
        int rightPtr = 0;

        while(leftPtr < array1.length && rightPtr < array2.length){
            if(array1[leftPtr] > array2[rightPtr]){
                answer.add(array2[rightPtr]);
                rightPtr++;
            } else {
                answer.add(array1[leftPtr]);
                leftPtr++;
            }
        }

        if(leftPtr == array1.length){
            for(int i=rightPtr; i< array2.length; i++){
                answer.add(array2[i]);
            }
        }

        if(rightPtr == array2.length){
            for(int i=leftPtr; i< array1.length; i++){
                answer.add(array1[i]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
