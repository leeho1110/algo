package ps.inflearntw.greedy;

import java.util.*;

public class MaxIncome {

    /**
     * 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
     * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
     * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
     * <p>
     * 입력: 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
     * 출력: 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
     */

    public int findMax(List<Lecture> asList) {
        Collections.sort(asList);

        Map<Integer, Integer> answers = new HashMap();

        for (Lecture lecture : asList) {
            answers.put(lecture.day, Math.max(answers.getOrDefault(lecture.day, lecture.pay), lecture.pay));
        }

        return answers.values().stream().mapToInt(Integer::intValue).sum();
    }


    static class Lecture implements Comparable<Lecture> {
        private int pay;
        private int day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.day - o.day == 0 ? o.pay - this.pay : this.day - o.day;
        }
    }
}
