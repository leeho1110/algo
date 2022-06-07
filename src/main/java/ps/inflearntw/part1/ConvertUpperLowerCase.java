package ps.inflearntw.part1;

import java.util.Scanner;

public class ConvertUpperLowerCase {

    public String solution(String inputStr){
        String answer = "";

        for(char inputChar : inputStr.toCharArray()){
            if(Character.isUpperCase(inputChar)){
                answer += Character.toLowerCase(inputChar);
            }

            if(Character.isLowerCase(inputChar)){
                answer += Character.toUpperCase(inputChar);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        String inputStr = in.next();

        ConvertUpperLowerCase m = new ConvertUpperLowerCase();
        System.out.println(m.solution(inputStr));

    }
}
