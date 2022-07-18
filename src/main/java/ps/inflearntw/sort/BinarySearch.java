package ps.inflearntw.sort;

public class BinarySearch {
    private final int[] numbers;

    public BinarySearch(int[] numbers) {
        this.numbers = numbers;
    }

    public int find(int target) {
        for(int i=0; i<numbers.length; i++){
            for(int j=0; j< numbers.length-1-i; j++){
                if(numbers[j] > numbers[j+1]){
                    int temp = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        int answer = -1;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == target){
                answer = i+1;
            }
        }

        return answer;
    }
}
