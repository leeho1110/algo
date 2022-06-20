package ps.inflearntw.twopointer;

public class Subsequence {
    private int criteria;
    private int target;
    private int[] numbers;
    private int answer;
    private int leftPointer;

    public Subsequence(int[] numbers, int criteria) {
        this.numbers = numbers;
        this.criteria = criteria;
    }

    public int findAvailableCase() {
        for(int rightPointer = 0; rightPointer<numbers.length; rightPointer++){
            // RT
            addTargetWithValueOf(rightPointer);

            if(isEqualToCriteria(target)){
                answer++;
            }

            subtractUntilEqualOrBiggerThanCriteria();
        }
        return answer;
    }

    private void subtractUntilEqualOrBiggerThanCriteria() {
        while(isEqualOrBiggerTo(target)){
            subtractLeftPointersValue();

            if(isEqualToCriteria(target)){
                answer++;
            }
        }
    }

    private void subtractLeftPointersValue() {
        target -= numbers[leftPointer++];
    }

    private boolean isEqualOrBiggerTo(int sum) {
        return sum >= criteria;
    }

    private boolean isEqualToCriteria(int sum) {
        return sum == criteria;
    }

    private void addTargetWithValueOf(int rightPointer) {
        target += numbers[rightPointer];
    }
}
