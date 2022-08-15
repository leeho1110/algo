package ps.inflearntw.twopointer;

import java.util.LinkedList;
import java.util.List;

public class ConcatTwoArray {

    private final int[] numbers1;
    private final int[] numbers2;

    private List<Integer> answer = new LinkedList<>();
    private int leftPointer = 0;
    private int rightPointer = 0;

    private ConcatTwoArray(int[] numbers1, int[] numbers2) {
        this.numbers1 = numbers1;
        this.numbers2 = numbers2;
    }

    public static ConcatTwoArray of(int[] numbers1, int[] numbers2) {
        return new ConcatTwoArray(numbers1, numbers2);
    }

    public int[] concat() {
        findSmallerValueUntilAnyPointerIsEnded();
        addLeastArraysValue();
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void addLeastArraysValue() {
        if(leftPointer == numbers1.length){
            for (int i = rightPointer; i < numbers2.length; i++) {
                answer.add(numbers2[i]);
            }
        }

        if(rightPointer == numbers2.length){
            for (int i = leftPointer; i < numbers1.length; i++) {
                answer.add(numbers1[i]);
            }
        }
    }

    private void findSmallerValueUntilAnyPointerIsEnded() {
        while(untilAnyArraySearchIsEnded(leftPointer, rightPointer)){
            if(compareTo(leftPointer, rightPointer)){
                answer.add(numbers1[leftPointer]);
                leftPointer++;
            } else {
                answer.add(numbers2[rightPointer]);
                rightPointer++;
            }
        }
    }

    private boolean compareTo(int leftPointer, int rightPointer) {
        return numbers1[leftPointer] < numbers2[rightPointer];
    }

    private boolean untilAnyArraySearchIsEnded(int leftPointer, int rightPointer) {
        return leftPointer < numbers1.length && rightPointer < numbers2.length;
    }
}
