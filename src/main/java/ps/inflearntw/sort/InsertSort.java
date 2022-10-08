package ps.inflearntw.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertSort {
    private final int[] numbers;

    public InsertSort(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] sort() {
        // 삽입 정렬은
        // 전체 배열에서 1번 인덱스에서 시작하며 하나씩 내려가면 자신 뒤에 있는 숫자와 비교해 값을 바꾼다

        // 전체 배열에서 두번쨰 인덱스부터 탐색을 시작한다
        for (int i = 1; i < numbers.length; i++) {
            // 자신의 한칸 뒤로 움직이며 자신보다 크면 뒤로, 작으면 그대로 둔다
            for (int j = i; j > 0 ; j--) {
                if(numbers[j-1] > numbers[j]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = temp;
                }
            }
        }

        return numbers;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[Integer.parseInt(bufferedReader.readLine())];

        String numbersString = bufferedReader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(numbersString," ");

        int idx=0;
        while (tokenizer.hasMoreTokens()){
            numbers[idx++] = Integer.parseInt(tokenizer.nextToken());
        }

        InsertSort sort = new InsertSort(numbers);
        int[] sort1 = sort.sort();

        for (int i : sort1) {
            System.out.print(i + " ");
        }

    }
}
