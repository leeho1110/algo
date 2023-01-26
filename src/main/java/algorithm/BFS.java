package algorithm;

import java.util.*;

public class BFS {

    private static Queue<NodeBase> nodes = new LinkedList();

    private List<Long> answer = new ArrayList<>();

    public List<Long> search(NodeBase node) {
        /**
         * 맨 위에서부터 시작을 합니다.
         *
         * 레벨 탐색이므로 먼저 자기 자신을 큐에 넣습니다. 왜? 루트부터 호출되어야 하니까
         * -> Q[1]
         *
         * 이 뒤부터는 대기큐가 비어있지 않다면(아직 탐색할 것이 남아있다면) 계속 탐색합니다.
         *
         * 1. 큐 전체를 순회하면서 큐에서 순서대로 하나씩 꺼내 출력합니다.
         * -> 1번째: Q[1] -> Q[]
         * -> 2번째: Q[2,3] -> Q[3]
         * -> 3번째: Q[3,4,5] -> Q[4,5]
         * -> 4번째: Q[4,5,6,7] -> Q[5,6,7]
         * -> 이후 5,6,7이 출력
         *
         * 2. 좌측 노드와 우측 노드가 비어있지 않다면 큐에 해당 노드들을 넣습니다.
         * -> 1번째: Q[] -> Q[2,3]
         * -> 2번째: Q[3] -> Q[3,4,5]
         * -> 3번째: Q[4,5] -> Q[4,5,6,7]
         * -> 4번째: Q[5,6,7] -> 5는 비어있으니, 그대로 Q[5,6,7]
         * -> 이후 5,6,7이 순서대로 제거
         *
         * 3. 로직을 종료합니다. (큐가 비어있지 않으니 상위 로직을 다시 순화합니다)
         */
        // 1. 탐색을 시작하기 전 루트 노드를 ready Queue에 삽입
        nodes.offer(node);

        while (isWorkQueueEmpty()) {
            for (int i = 0; i < nodes.size(); i++) {
                NodeBase poll = nodes.poll();
                answer.add(poll.getValue());

                if (poll.getLeftNode() != null) {
                    nodes.offer(poll.getLeftNode());
                }

                if (poll.getRightNode() != null) {
                    nodes.offer(poll.getRightNode());
                }
            }
        }

        return answer;
    }

    private boolean isWorkQueueEmpty() {
        return !nodes.isEmpty();
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        List<Long> search = bfs.search(NodeBase.createOneToSevenTree());
        for (Long nodeBase : search) {
            System.out.println("nodeBase = " + nodeBase);
        }
    }
}
