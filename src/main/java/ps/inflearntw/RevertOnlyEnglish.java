package ps.inflearntw;

import java.util.Scanner;

public class RevertOnlyEnglish {

    public String solution(String input){
        char[] answer = input.toCharArray();
        int ltIdx=0;
        int rtIdx=input.length()-1;

        while(ltIdx < rtIdx){
            if(Character.isAlphabetic(answer[ltIdx])){
                ltIdx++;
            } else if(Character.isAlphabetic(answer[rtIdx])){
                rtIdx--;
            } else {
                changeLocation(answer, ltIdx, rtIdx);
                ltIdx++;
                rtIdx--;
            }
        }

        return String.valueOf(answer);
    }

    private void changeLocation(char[] answer, int ltIdx, int rtIdx){
        char temp = answer[ltIdx];
        answer[ltIdx] = answer[rtIdx];
        answer[rtIdx] = temp;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String inputString = in.next();

        RevertOnlyEnglish m = new RevertOnlyEnglish();
        System.out.println(m.solution(inputString));
    }
}
