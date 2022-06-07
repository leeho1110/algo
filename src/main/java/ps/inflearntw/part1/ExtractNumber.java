package ps.inflearntw.part1;

import java.util.Scanner;

public class ExtractNumber {

    public int solution(String input){
        String numberString = "";

        String onlyNum = extractNumber(input);
        for(char each : onlyNum.toCharArray()){
            numberString += each;
        }

        return Integer.parseInt(numberString);
    }

    private String extractNumber(String input){
        return input.replaceAll("[^0-9]","");
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.next();

        ExtractNumber main = new ExtractNumber();
        System.out.println(main.solution(input));
    }
}
