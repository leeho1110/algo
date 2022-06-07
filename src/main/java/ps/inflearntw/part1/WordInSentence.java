package ps.inflearntw.part1;

import java.util.Scanner;

public class WordInSentence {

    private String answer = "";

    public String solution(String inputString){
        String answer = "";
        String[] wordSplitedBySpace = inputString.split(" ");

        for(int i=wordSplitedBySpace.length-1; i>=0; i--){
            String word = wordSplitedBySpace[i];
            if(isLongerThan(word)){
                answer = word;
            }
        }

        return answer;
    }

    private boolean isLongerThan(String word){
        return answer.length() <= word.length();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        String inputString = in.nextLine();

        WordInSentence m = new WordInSentence();
        System.out.println(m.solution(inputString));

    }
}
