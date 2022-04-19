package ps.inflearntw;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ShortestDistance {

    private char specific;
    private String text;
    private int[] answer;

    public ShortestDistance(char specific, String text){
        this.specific = specific;
        this.text = text;
        answer = new int[text.length()];
    }

    public int[] checkDistance(){
        int maxDistance=99;

        for(int i=0; i<text.length(); i++){
            if(text.charAt(i) == specific){
                maxDistance = 0;
            } else {
                maxDistance++;
            }
            answer[i] = maxDistance;
        }

        maxDistance=99;
        for(int i=text.length()-1; i>=0; i--){
            if(text.charAt(i) == specific){
                maxDistance = 0;
            } else {
                maxDistance++;
                answer[i] = Math.min(maxDistance, answer[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] inputList = input.split(" ");
        ShortestDistance m = new ShortestDistance(inputList[1].charAt(0), inputList[0]);

        for(int each : m.checkDistance()){
            System.out.print(each + " ");
        }
    }
}
