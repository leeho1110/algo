package ps.inflearntw.stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class CurriculumValidator {

    public static final String INVALID = "NO";
    public static final String VALID = "YES";
    private final Queue<Character> mandatorySubjects = new ArrayDeque<>();

    public static CurriculumValidator createMandatorySubjectsFrom(String mandatory){
        return new CurriculumValidator(mandatory);
    }

    public CurriculumValidator(String mandatory) {
        for (char subject : mandatory.toCharArray()) {
            mandatorySubjects.add(subject);
        }
    }

    public String validate(String curriculum) {
        for (Character subject : curriculum.toCharArray()) {
            if(isMandatory(subject) && isDiffWithNextMandatory(subject)){
                return INVALID;
            }
        }

        if(hasMandatorySubject()){
            return INVALID;
        }

        return VALID;
    }

    private boolean isMandatory(Character subject) {
        return mandatorySubjects.contains(subject);
    }

    private boolean isDiffWithNextMandatory(Character subject) {
        return !(mandatorySubjects.poll() == subject);
    }

    private boolean hasMandatorySubject() {
        return !mandatorySubjects.isEmpty();
    }
}
