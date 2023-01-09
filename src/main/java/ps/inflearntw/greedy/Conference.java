package ps.inflearntw.greedy;

import java.util.Collections;
import java.util.List;

public class Conference {

    /**
     * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
     * 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
     * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
     *
     * 첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데
     * 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.
     * 회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
     */

    public int findMax(List<ConferenceTime> conferenceTimes) {
        // 변수 초기화
        int answer = 0;
        int endTime = Integer.MIN_VALUE;

        // 종료시간에 맞춰서 정렬
        Collections.sort(conferenceTimes);

        // 최대한 빨리 끝나는 시간부터 검증해하며 다음 시작 시간에 들어갈 수 있는지 판단
        for (ConferenceTime conferenceTime : conferenceTimes) {
            if(conferenceTime.startTime >= endTime){
                answer++;
                endTime = conferenceTime.endTime;
            }
        }

        return answer;
    }

    static class ConferenceTime implements Comparable<ConferenceTime> {
        private int startTime;
        private int endTime;

        public ConferenceTime(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        /**
         *  최대한 일찍 끝나는 회의들을 모아서 최대한 많은 회의를 개최해야합니다.
         *  따라서 끝나는 시간을 기준으로 오름차순을 정렬한 뒤, 시작 시간만 일치하면 바로 뱉을 수 있게 한다.
         */
        @Override
        public int compareTo(ConferenceTime o) {
            // 만약 종료하는 시간이 똑같다면 시작시간을 기준으로 정렬해야한다.
            if(this.endTime == o.endTime){
                return this.startTime - o.startTime;
            } else {
                // 아니라면 종료시간을 기준으로 정렬한다.
                return this.endTime - o.endTime;
            }
        }
    }
}
