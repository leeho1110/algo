package ps.inflearntw;

import java.util.Scanner;

public class ShortestDistance {

    private char specific;
    private String text;

    private int distance;
    private int[] answer;

    public ShortestDistance(char specific, String text){
        this.specific = specific;
        this.text = text;
        answer = new int[text.length()];
    }

    public int[] checkDistance(){
        getBaseDistance();
        getShortestDistance();
        return answer;
    }

    private void getBaseDistance() {
        initializeDistanceToMax();
        for(int i=0; i<text.length(); i++){
            checkDistance(i);
            answer[i] = distance;
        }
    }

    private void getShortestDistance() {
        initializeDistanceToMax();
        for(int i=text.length()-1; i>=0; i--){
            checkDistance(i);
            answer[i] = Math.min(distance, answer[i]);
        }
    }

    private void checkDistance(int i) {
        if(text.charAt(i) == specific){
            distance = 0;
        } else {
            distance++;
        }
    }

    private void initializeDistanceToMax() {
        this.distance = 99;
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
