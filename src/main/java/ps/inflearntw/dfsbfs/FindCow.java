package ps.inflearntw.dfsbfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindCow {


    private final int myLocation;
    private int jumpTime;
    private Set<Integer> alreadyChecked = new HashSet();
    private Queue<Integer> searchNodes = new LinkedList<>();

    public FindCow(int myLocation) {
        this.myLocation = myLocation;
    }

    public int findShortest(int cowLocation, int[] jumpDistance) {

        /**
         * TODO
         * - BFS를 사용한 레벨 탐색
         * - 가능한 점프 거리는 {1, -1, 5}
         * - 내 위치에서 가능한 점프 거리만큼 하위 리프노드를 뻗어나가며 탐색하기
         * - 루트에서 위 점프 거리를 차례로 늘려가면서
         * - 송아지 위치를 찾게 되면 해당 레벨 수를 리턴한다.
         */

        alreadyChecked.add(myLocation);
        searchNodes.offer(myLocation);

        while (!searchNodes.isEmpty()) {
            // 검색 큐의 하나의 레벨의 길이를 구합니다.
            int sizeOfNodeLevel = searchNodes.size();
            for (int i = 0; i < sizeOfNodeLevel; i++) {
                // 가장 앞에 있는 루트 노드를 꺼내고
                int location = searchNodes.poll();
                // 가능한 점프 거리를 탐색한다.
                for (int j = 0; j < jumpDistance.length; j++) {
                    // 만약 가능한 점프 거리가 음수보다 작다면
                    int locationAfterJump = location + jumpDistance[j];
                    if (locationAfterJump > 0) {
                        // 점프한 거리가 송아지 거리랑 똑같은지 체크해본다, 만약 똑같다면 다음 레벨로 값을 더해주기 전에 발견한 것이므로 탐색 횟수를 1 더해줘야한다.
                        if (locationAfterJump == cowLocation) {
                            return jumpTime + 1;
                        } else {// 만약 다르다면, 다음 거리를 측정해야하니까 나온 결과물들을 다음 탐색 노드에 넣는다
                            // 만약 이 때 이미 탐색한 거리라면 넣지 않는다.
                            if (!alreadyChecked.contains(locationAfterJump)) {
                                alreadyChecked.add(locationAfterJump);
                                searchNodes.add(locationAfterJump);
                            }
                        }
                    }
                }
            }
            // 점프를 한번 했음에도 없는거니 다음 점프로
            jumpTime++;
        }
        return jumpTime;
    }
}
