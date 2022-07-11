package ps.inflearntw.sort;

public class BubbleSort {
    private final int[] numbers;

    public BubbleSort(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] sort() {
        for(int i=0; i<numbers.length-1; i++){
            for(int j=0; j<numbers.length-i-1; j++){
                if(numbers[j] > numbers[j+1]){
                    int temp = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        return numbers;
    }
}
