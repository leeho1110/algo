package ps.inflearntw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RevertWord {

    public List<String> solution(String[] words){
        List<String> revertedWords = new ArrayList<String>();

        for(String word : words){
            revertedWords.add(revertSpell(word));
        }

        return revertedWords;
    }

    public String revertSpell(String word){
        StringBuilder revertedWord = new StringBuilder();

        for(char character : word.toCharArray()){
            revertedWord.insert(0,character);
        }

        return revertedWord.toString();
    }

    public String[] splitWordByComma(String input){
        return input.split(",");
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int inputAmount = in.nextInt();
        String inputString = "";

        for(int i=0; i<inputAmount; i++){
            inputString += in.next() + ",";
        }

        RevertWord m = new RevertWord();
        String[] words = m.splitWordByComma(inputString);
        List<String> answers = m.solution(words);

        for(String answer : answers){
            System.out.println(answer);
        }
    }
}
