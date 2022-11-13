package ps.inflearntw.dfsbfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ps.inflearntw.dfsbfs.GraphSearchingByLinkedList.VISITING.NON_VISIT;
import static ps.inflearntw.dfsbfs.GraphSearchingByLinkedList.VISITING.VISIT;

/**
 * 방향 그래프가 주어졌을 때 1번 정점부터 N번 정점으로 가는 모든 경로의 가지수를 출력하는 프로그램을 작성하세요.
 */
public class GraphSearchingByLinkedList {

    enum VISITING {
        VISIT(1), NON_VISIT(0);

        private final int value;

        VISITING(int value) {
            this.value = value;
        }
    }
    private final List<List<Integer>> directedGraph;
    private int[] visitedNodes;
    private int destination;
    private int answer;

    public GraphSearchingByLinkedList(List<List<Integer>> directedGraph) {
        this.directedGraph = directedGraph;
        this.visitedNodes = new int[directedGraph.size()];
    }

    public int findAllCaseOfVisit(int destination){
        this.destination = destination;
        visitedNodes[1] = VISIT.value;
        DFS(1);
        return answer;
    }

    private void DFS(int nodeThatWannaVisit){ // 1번노드부터 탐색한다.
        if(isEqualToDestination(nodeThatWannaVisit, destination)){
            answer++;
        } else {
             for(int visitableNode: findAVisitableCase(nodeThatWannaVisit)){
                 if(isFirstTime(visitableNode)){
                     visitedNodes[visitableNode] = VISIT.value;
                     DFS(visitableNode);
                     visitedNodes[visitableNode] = NON_VISIT.value;
                 }
             }
        }

    }

    private boolean isEqualToDestination(int nodeThatWannaVisit, int destination) {
        return nodeThatWannaVisit == destination;
    }

    private boolean isFirstTime(int visitableNode) {
        return isEqualToDestination(visitedNodes[visitableNode], 0);
    }

    private List<Integer> findAVisitableCase(int nodeThatWannaVisit) {
        return directedGraph.get(nodeThatWannaVisit);
    }

    public static void main(String[] args) {

        List<Integer> nonIndexNode = Collections.emptyList();
        List<Integer> nodeNumber1 = Arrays.asList(2,3,4);
        List<Integer> nodeNumber2 = Arrays.asList(1,3,5);
        List<Integer> nodeNumber3 = Arrays.asList(4);
        List<Integer> nodeNumber4 = Arrays.asList(2,5);
        List<Integer> nodeNumber5 = Collections.emptyList();

        List<List<Integer>> graph = Arrays.asList(nonIndexNode, nodeNumber1,nodeNumber2,nodeNumber3,nodeNumber4,nodeNumber5);

        GraphSearchingByLinkedList graphSearcher = new GraphSearchingByLinkedList(graph);
        int result = graphSearcher.findAllCaseOfVisit(5);
        System.out.println("result = " + result);
    }
}
