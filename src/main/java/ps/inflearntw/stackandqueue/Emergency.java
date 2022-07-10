package ps.inflearntw.stackandqueue;

import java.util.*;

public class Emergency {
    private final Queue<Patient> patients = new ArrayDeque<>();
    private Integer answer = 0;

    public Emergency(int[] patients) {
        for (int i = 0; i < patients.length; i++) {
            this.patients.add(new Patient(i, patients[i]));
        }
    }

    public Integer takeCare(int sequence) {
       while(!patients.isEmpty()){
            Patient patient = patients.poll();

            for (Patient patient1 : patients) {
                if (patient1.getPriority() > patient.getPriority()) {
                    patients.offer(patient);
                    patient = null;
                    break;
                }
            }

            if (patient != null) {
                answer++;
                if (patient.getSequence() == sequence) {
                    return answer;
                }
            }
        }
        return answer;
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
