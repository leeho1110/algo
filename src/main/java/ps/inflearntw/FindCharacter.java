package ps.inflearntw;

import java.util.Scanner;

public class FindCharacter {

    public int solution(String str, char c) {
        int answer = 0;

        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
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
