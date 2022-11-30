package ps.inflearntw.sort;

import java.util.*;
import java.util.stream.IntStream;

public class Jangnan {
    private final int[] students;

    public Jangnan(int[] students) {
        this.students = students;
    }

    public int[] find() {
        List<Integer> answer = new ArrayList<>();

        int[] sortedStudents = students.clone();
        Arrays.sort(sortedStudents);

        for (int i = 0; i <students.length; i++) {
            if(students[i] != sortedStudents[i]){
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
