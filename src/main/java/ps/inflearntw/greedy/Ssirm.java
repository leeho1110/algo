package ps.inflearntw.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ssirm {

    /**
     * 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
     * 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
     * 현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
     * “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
     * 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
     * <p>
     * 첫째 줄에 지원자의 수 N(5<=N<=30,000)이 주어집니다.
     * 두 번째 줄부터 N명의 흰돌 능력치와 검은돌 능력치 정보가 차례로 주어집니다.
     * 각 선수의 흰돌능력치가 모두 다르고, 검은돌 능력치도 모두 다릅니다. 능력치 값은 1,000,000이하의 자연수입니다.
     * <p>
     * 첫째 줄에 바둑 선수로 뽑히는 최대 인원을 출력하세요.
     */

    static class Body implements Comparable<Body> {
        private int height;
        private int weight;

        public Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Body another) {
            return another.height - this.height;
        }
    }
    private int answer;

    public int findMax(List<Body> members) {
        /**
         * Collections.sort를 통해 가장 키가 큰 사람보다 나머지 모든 사람이 키가 작다는 것을 가정
         * 만약 선발되기 위해선 키, 몸무게 중 하나라도 높아야 한다.
         *
         * 순회 탐색하며 현재까지 발견한 몸무게의 최대값보다 높은지 확인한다.
         * 그렇다면 키는 작아도 몸무게가 높으므로 선발된다.
         *
         * 그리고 선발 가능 여부를 판단하는 최대 몸무게는 갱신되어야 한다.
         * 만약 그렇지 않다면 키(자동 정렬로 인해 당연히 작고)와 몸무게(기준이 변경되지 않아)가 모두 작은 누군가가 선발되므로
         */

        Collections.sort(members);
        int maxWeight = Integer.MIN_VALUE;

        for (Body member : members) {
            if(member.weight > maxWeight){
                answer++;
                maxWeight = member.weight;
            }
        }

        return answer;
    }
}
