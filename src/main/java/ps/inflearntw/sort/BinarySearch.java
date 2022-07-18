package ps.inflearntw.sort;

public class BinarySearch {
    private final int[] numbers;
    private int answer;

    public BinarySearch(int[] numbers) {
        this.numbers = numbers;
    }

    public int find(int target) {
        bubbleSort();
        findIndexOf(target);
        return answer;
    }

    private void findIndexOf(int target) {
        for (int i = 0; i < numbers.length; i++) {
            if(isEqualToTarget(target, i)){
                answer = i+1;
            }
        }
    }

    private boolean isEqualToTarget(int target, int i) {
        return numbers[i] == target;
    }

    private void bubbleSort() {
        for(int i=0; i<numbers.length; i++){
            for(int j=0; j< numbers.length-1-i; j++){
                if(numbers[j] > numbers[j+1]){
                    int temp = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}
