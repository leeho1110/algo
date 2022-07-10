package ps.inflearntw.stackandqueue;

import java.util.*;

public class Emergency {
    private final Queue<Patient> patients = new ArrayDeque<>();
    private Integer answer = 0;
    private int sequence;

    public Emergency(int[] patients) {
        for (int i = 0; i < patients.length; i++) {
            this.patients.add(new Patient(i, patients[i]));
        }
    }

    public Integer takeCare(int sequence) {
        this.sequence = sequence;
        while (!patients.isEmpty()) {
            Patient target = patients.poll();

            for (Patient patient : patients) {
                if (isMoreDangerousThan(patient, target)) {
                    patients.offer(target);
                    target = null;
                    break;
                }
            }

            if (isMostDangerous(target)) {
                answer++;
                if (isEqualToSequence(target)) {
                    return answer;
                }
            }
        }
        return answer;
    }

    private boolean isEqualToSequence(Patient target) {
        return target.getSequence() == sequence;
    }

    private boolean isMostDangerous(Patient target) {
        return target != null;
    }

    private boolean isMoreDangerousThan(Patient patient, Patient target) {
        return patient.getPriority() > target.getPriority();
    }

    static class Patient {
        private int sequence;
        private int priority;

        public Patient(int sequence, int priority) {
            this.sequence = sequence;
            this.priority = priority;
        }

        public int getSequence() {
            return sequence;
        }

        public int getPriority() {
            return priority;
        }
    }
}
