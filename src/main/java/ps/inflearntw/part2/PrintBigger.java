package ps.inflearntw.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintBigger {
    private List<Integer> numbers;

    public PrintBigger(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void split(String textWithWhitespace) {
        for (String eachText : textWithWhitespace.split(" ")) {
            numbers.add(Integer.parseInt(eachText));
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean isBiggerThanPrev(int index) {
        return numbers.get(index) > numbers.get(index-1);
    }

    public String printBigger() {
        StringBuilder answer = new StringBuilder(getFirstCharacter());

        for (int i = 1; i< numbers.size(); i++) {
            if(isBiggerThanPrev(i)){
                answer.append(" " + numbers.get(i));
            };
        }

        return answer.toString();
    }

    private String getFirstCharacter() {
        return String.valueOf(numbers.get(0));
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        int length = in.nextInt();
        List<Integer> numbers = new ArrayList<Integer>();

        for(int i=0; i<length; i++){
            numbers.add(in.nextInt());
        }

        PrintBigger m = new PrintBigger(numbers);
        System.out.println(m.printBigger());
    }
}
