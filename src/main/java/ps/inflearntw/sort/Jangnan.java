package ps.inflearntw.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Jangnan {
    private final int[] students;

    public Jangnan(int[] students) {
        this.students = students;
    }

    public int[] find() {
        List<Integer> answer = new ArrayList<>();

        int[] rightOrder = students.clone();

        for(int i=0; i< rightOrder.length; i++){
            for(int j=0; j<rightOrder.length-i-1; j++){
                if(rightOrder[j] > rightOrder[j+1]){
                    int temp = rightOrder[j+1];
                    rightOrder[j+1] = rightOrder[j];
                    rightOrder[j] = temp;
                }
            }
        }

        for(int i=0; i< students.length; i++){
            if(students[i] != rightOrder[i]){
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
