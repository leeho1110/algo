package ps.inflearntw;

import java.util.Scanner;

public class ValidPalindromeString {

    public String solution(String input){
        if(isNotPerlindrome(input)){
            return "NO";
        }

        return "YES";
    }

    private boolean isNotPerlindrome(String input){
        String reverseInput = new StringBuilder(input).reverse().toString();
        return !input.equalsIgnoreCase(reverseInput);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        String input = in.nextLine();
        input = input.replaceAll("[^a-zA-z]", "");

        ValidPalindromeString main = new ValidPalindromeString();
        System.out.println(main.solution(input));
    }
}
