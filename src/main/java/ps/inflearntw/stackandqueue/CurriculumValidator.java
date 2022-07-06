package ps.inflearntw.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class CurriculumValidator {

    private final Queue<Character> mandatorySubjects = new ArrayDeque<>();

    public CurriculumValidator(String mandatory) {
        for (char subject : mandatory.toCharArray()) {
            mandatorySubjects.add(subject);
        }
    }

    public String validate(String curriculum) {
        for (Character subject : curriculum.toCharArray()) {
            if(mandatorySubjects.contains(subject)){
                if(!(mandatorySubjects.poll() == subject)){
                    return "NO";
                }
            }
        }

        if(!mandatorySubjects.isEmpty()){
            return "NO";
        }

        return "YES";
    }
}
