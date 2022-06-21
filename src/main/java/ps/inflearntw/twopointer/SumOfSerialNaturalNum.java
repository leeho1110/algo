package ps.inflearntw.twopointer;

public class SumOfSerialNaturalNum {
    private final int criteria;

    private int startPointer = 1;
    private int endPointer = 1;
    private int sum;
    private int answer;

    public SumOfSerialNaturalNum(int criteria) {
        this.criteria = criteria;
    }

    public int findAvailableCase() {
        for(int i=0; i<criteria/2+1; i++){
            // RT를 더하고 1씩 증가
            plusSumToEndPointerValue();

            // sum이 기준보다 크거나 같을 때까지 더해
            if(isSumEqualToCriteria()){
                answer++;
            }

            // 만약 기준보다 커지면 LT를 빼면서 움직일 차례
            while(isSumBiggerOrEqualToCriteria()){
                minusSumToStartPointerValue();
                if(isSumEqualToCriteria()){
                    answer++;
                }
            }
        }
        return answer;
    }

    private void minusSumToStartPointerValue() {
        sum -= startPointer++;
    }

    private boolean isSumBiggerOrEqualToCriteria() {
        return sum >= criteria;
    }

    private boolean isSumEqualToCriteria() {
        return sum == criteria;
    }

    private void plusSumToEndPointerValue() {
        sum += endPointer++;
    }
}
