package ps.inflearntw.twopointer;

public class Subsequence {
    private int criteria;
    private int sum;
    private int[] numbers;
    private int answer;
    private int leftPointer;
    private int rightPointer;

    public Subsequence(int[] numbers, int criteria) {
        this.numbers = numbers;
        this.criteria = criteria;
    }

    public int findAvailableCase() {
        for (rightPointer = 0; rightPointer < numbers.length; rightPointer++) {
            addSumToValueOf(rightPointer);
            findFromEndPointer();
            findFromStartPointer();
        }
        return answer;
    }

    private void findFromEndPointer() {
        if (isEqualToCriteria(sum)) {
            answer++;
        }
    }

    private void findFromStartPointer() {
        while (isEqualOrBiggerTo(sum)) {
            minusLeftPointersValueAndMoveIndex();
            if (isEqualToCriteria(sum)) {
                answer++;
            }
        }
    }

    private void minusLeftPointersValueAndMoveIndex() {
        sum -= numbers[leftPointer++];
    }

    private boolean isEqualOrBiggerTo(int sum) {
        return sum >= criteria;
    }

    private boolean isEqualToCriteria(int sum) {
        return sum == criteria;
    }

    private void addSumToValueOf(int rightPointer) {
        sum += numbers[rightPointer];
    }
}
