package ps.inflearntw.sort;

public class SelectedSort {
    private final int[] numbers;

    public SelectedSort(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] sort() {
        for(int i=0; i<numbers.length-1; i++){
            int minIdx = i;
            for(int j=i; j<numbers.length; j++){
                if(numbers[j] < numbers[minIdx]){
                    minIdx = j;
                }
            }

            int temp = numbers[i];
            numbers[i] = numbers[minIdx];
            numbers[minIdx] = temp;
        }

        return numbers;
    }
}
