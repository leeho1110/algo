package ps.inflearntw;

import java.util.Scanner;

public class FindCharacter {

    public int solution(String inputString, char inputChar) {
        int answer = 0;

        inputString = inputString.toUpperCase();
        inputChar = Character.toUpperCase(inputChar);

        for(char iterChar : inputString.toCharArray()){
            if (inputChar == iterChar) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();
        char c = in.next().charAt(0);
        FindCharacter m = new FindCharacter();
        System.out.println(m.solution(str, c));
    }
}
