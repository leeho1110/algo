package ps.inflearntw;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumber {
    private int hang;
    private List<Integer> answer;

    public FibonacciNumber(int hang) {
        setHang(hang);
        initializeSequence();
    }

    private void initializeSequence() {
        List<Integer> defaultSequence = new ArrayList<Integer>();
        defaultSequence.add(1); defaultSequence.add(1); defaultSequence.add(2);

        setAnswer(defaultSequence);
    }

    public static FibonacciNumber from(int i) {
        return new FibonacciNumber(i);
    }

    public int getHang() {
        return this.hang;
    }

    private void setHang(int hang) {
        this.hang = hang;
    }

    public List<Integer> createSequence() {
        // 수열을 추가하는 건 마지막 항과 마지막-1 항을 더해서 추가
        // 들어온 항과 초기값의 차이를 구해
        // 그 수만큼 수열을 추가해
        int cycle = calculateExecuteCount();
        for(int i=0; i<cycle; i++){

            addSequence();
        }

        return answer;
    }

    private void addSequence() {
        answer.add(calculateLastSequce());
    }

    private int calculateLastSequce() {
        return answer.get(answer.size() - 1) + answer.get(answer.size() - 2);
    }

    private int calculateExecuteCount() {
        return hang - answer.size();
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    private void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
}
