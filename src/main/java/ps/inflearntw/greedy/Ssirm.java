package ps.inflearntw.greedy;

import java.util.Arrays;

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

    private int answer;

    public int findMax(int[][] members) {

        m

        // 전체 순회 탐색
        for (int i = 0; i < members.length; i++) {
            boolean choiceFlag = true;

            for (int j = 0; j < members.length; j++) {

                if(members[j][0] == members[i][0] && members[j][1] == members[i][1]){
                    continue;
                }

                if (members[j][0] > members[i][0] && members[j][1] > members[i][1]) {
                    choiceFlag = false;
                    break;
                }
            }

            if(choiceFlag){
                answer++;
            }

        }

        return answer;
    }
}
