package ps.inflearntw.dfsbfs;

public class GraphSearchingByDFS {

    private final int[][] graph;
    private int[] checked;
    private int destination;
    private int answer;

    public GraphSearchingByDFS(int[][] graph) {
        this.graph = graph;
        this.checked = new int[graph.length];
    }

    public int findAllCaseOf(int destination){
        this.destination = destination;
        checked[1] = 1;
        DFS(1);
        return answer;
    }

    private void DFS(int startNode){
        if(isArriveToDestination(startNode)){
            answer++;
        } else {
            for(int i = 1; i<= destination; i++){
                if(isAvailableNodeAndNonpassed(startNode, i)){
                    checked[i] = 1;
                    DFS(i);
                    checked[i] = 0;
                }
            }
        }
    }

    private boolean isAvailableNodeAndNonpassed(int startNode, int i) {
        return graph[startNode][i] == 1 && checked[i] == 0;
    }

    private boolean isArriveToDestination(int startNode) {
        return startNode == destination;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
        };

        // 그래프 내부를 모두 탐색하는 가짓수를 출력하
        GraphSearchingByDFS graphSearchingByDFS = new GraphSearchingByDFS(graph);
        int result = graphSearchingByDFS.findAllCaseOf(5);
        System.out.println("result = " + result);
    }

}
