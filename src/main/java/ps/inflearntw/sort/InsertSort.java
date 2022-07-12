package ps.inflearntw.sort;

public class InsertSort {
    private final int[] numbers;

    public InsertSort(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] sort() {


        // 삽입 정렬은 순회탐색하며
        for(int i=1; i<numbers.length; i++){
            int target = numbers[i];
            int swapIdx = -1;
            // 자신보다 뒤에 있는 요소들을 비교한다
            for(int j=i-1; j>=0; j--){
                // 한칸씩 내려가면서 만약 자신보다 크다면
                if(target < numbers[j]){
                    // 자신 바로 뒤로 밀어버리는 방식으로 정렬한다
                    numbers[j+1] = numbers[j];
                    swapIdx = j;
                } else {
                    // 크지 않다면 더이상 큰 요소가 없는 것이므로 탐색을 종료한다
                    break;
                }
            }
            numbers[swapIdx] = target;
        }

        return numbers;
    }
}
