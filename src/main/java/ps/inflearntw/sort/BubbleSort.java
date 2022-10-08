package ps.inflearntw.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BubbleSort {
    private final int[] numbers;

    public BubbleSort(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] sort() {
        
        // - 첫번째부터 마지막 인덱스의 한 칸 앞까지 다음 요소와 비교한다.
        //      - 큰 요소는 뒤로 작은 요소는 앞으로 옮긴다.
        //      - 다음 순번에는 탐색 범위가 1칸 빠진채로 수행
        for (int i = 0; i < numbers.length-1; i++) { // 전체 몇회전을 수행할 것인지를 결정
            for (int j = 0; j < numbers.length-1-i; j++) { // 탐색이 종료되면 반드시 마지막에는 최대값이 위치하므로 회전마다 체크하는 인덱스 범위를 하나씩 뺴줘서 조절해야함
                if(numbers[j] > numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        return numbers;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[count];

        String numbersString = bufferedReader.readLine();
        StringTokenizer st = new StringTokenizer(numbersString, " ");

        int idx=0;
        while (st.hasMoreTokens()){
            numbers[idx++] = Integer.parseInt(st.nextToken());
        }

        BubbleSort bubbleSort = new BubbleSort(numbers);
        int[] sort = bubbleSort.sort();
        for (int i : sort) {
            System.out.print(i + " ");
        }
    }
}
