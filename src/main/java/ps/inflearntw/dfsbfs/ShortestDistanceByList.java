package ps.inflearntw.dfsbfs;

import java.util.*;

public class ShortestDistanceByList {

    private final List<List<Integer>> directedGraph;
    private final int[] visitedNodes;
    private int[] distanceCosts;
    private int destination;

    enum VISITING {
        VISIT(1), NON_VISIT(0);

        private final int value;

        VISITING(int value) {
            this.value = value;
        }
    }

    public ShortestDistanceByList(List<List<Integer>> directedGraph) {
        this.directedGraph = directedGraph;
        this.visitedNodes = new int[directedGraph.size()];
        this.distanceCosts = new int[directedGraph.size()];
    }

    public int search(int destination) {
        this.destination = destination;
        BFS(1);
        return distanceCosts[destination];
    }

    private void BFS(int nodeThatWannaVisit) {
        this.visitedNodes[1] = VISITING.VISIT.value;

        Queue<Integer> workingQueue = new LinkedList<>();
        workingQueue.add(nodeThatWannaVisit);

        while (!workingQueue.isEmpty()) {
            // 내가 가려는 곳에 이미 방문했다고 체크한다. vi
            int node = workingQueue.poll();
            for (int visitableNode : directedGraph.get(node)) {
                if (visitedNodes[visitableNode] == 0) {
                    visitedNodes[visitableNode] = 1;
                    workingQueue.offer(visitableNode);
                    distanceCosts[visitableNode] = distanceCosts[node] + 1;
                }
            }
        }
    }
}
