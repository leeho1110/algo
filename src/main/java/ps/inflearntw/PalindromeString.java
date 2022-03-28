package ps.inflearntw;

import java.util.Scanner;

public class PalindromeString {

    // 앞에서 읽든 뒤에서 읽든 동일한 문자열을 찾아라
    // 문자열의 인덱스를 lt, rt로 나눠서 while문을 돌리고
    // 이때 둘이 한번이라도 틀리면 No

    private static final String PASS = "YES";
    private static final String NOPASS = "NO";

    private int leftIndex;
    private int rightIndex;

    public String solution(String input) {
        initializeIndex(input);
        char[] inputArray = input.toCharArray();

        while (leftIndex < rightIndex) {
            if (isDifferent(inputArray[leftIndex], inputArray[rightIndex])) {
                return NOPASS;
            }
            moveIndex();
        }

        return PASS;
    }

    private void initializeIndex(String input) {
        leftIndex = 0;
        rightIndex = input.length() - 1;
    }

    private boolean isDifferent(char input1, char input2) {
        return input1 != input2;
    }

    private void moveIndex() {
        this.leftIndex++;
        this.rightIndex--;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();

        PalindromeString m = new PalindromeString();
        System.out.println(m.solution(input.toUpperCase()));

    }
}
