package ps.inflearntw;

public class PrimeNumberCalculator {
    public static final int NORMAL_NUMBER = 1;
    public static final int PRIME_NUMBER = 0;
    private int[] numbers;
    private int answer;

    public PrimeNumberCalculator(int number) {
        // 입력된 자연수까지 소수가 아닌지를 체크하는 공간이 필요하다. 따라서 하나가 더 생겨야 한다.
        // ex. 자연수 3일 때 만약 new int[3] 을 하게 되면 인덱스가 2까지밖에 생기지 않음.
        // 따라서 n+1, new int[4]를 해줘야 [0,1,2,3]이 생성됨
        setNumber(new int[number + 1]);
    }

    public static PrimeNumberCalculator from(int number) {
        return new PrimeNumberCalculator(number);
    }

    public int findPrimeNumber() {
        // 0,1은 소수의 범위에서 포함되지 않으므로 2부터
        // 원하는 자연수까지 체크하기 위해선 아까 1을 더해 생성했던 배열의 길이보다 하나 작게
        for (int i = 2; i < numbers.length; i++) {
            // 소수일 때
            if (isPrimeNumber(i)) {
                // 소수 개수 +1
                addAnswer();
                // 소수인 숫자의 배수들은 전부 소수가 아니도록 체크
                // j = 소수, 지금 발견한 소수의 위치부터 끝까지 소수의 배수들을 체크해줌
                changeMulipleNumbersToNormal(i);
            }
        }
        return answer;
    }

    private void changeMulipleNumbersToNormal(int i) {
        for (int j = i; j < numbers.length; j += i) {
            changeNumberToNormal(j);
        }
    }

    private void changeNumberToNormal(int j) {
        numbers[j] = NORMAL_NUMBER;
    }

    private boolean isPrimeNumber(int i) {
        return numbers[i] == PRIME_NUMBER;
    }

    private void addAnswer() {
        answer++;
    }

    private void setNumber(int[] numbers) {
        this.numbers = numbers;
    }
}
