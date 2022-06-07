package ps.inflearntw.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePrimeNumber {
    private int[] numbers;

    public static ReversePrimeNumber from(int[] numbers) {
        return new ReversePrimeNumber(numbers);
    }

    public ReversePrimeNumber(int[] numbers) {
        int[] reversedNumbers = Arrays.stream(numbers)
                .map(this::reverse)
                .toArray();
        setNumbers(reversedNumbers);
    }
    private int reverse(int number) {
        String reversNumber = new StringBuilder(String.valueOf(number)).reverse().toString();
        return Integer.parseInt(reversNumber, 10);
    }

    public List<Integer> findPrimeNumber() {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (isPrimeNumber(numbers[i])) {
                answer.add(numbers[i]);
            }
        }

        return answer;
    }

    private boolean isPrimeNumber(int number) {
        if(number == 1) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
