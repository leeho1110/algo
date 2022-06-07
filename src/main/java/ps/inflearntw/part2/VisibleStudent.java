package ps.inflearntw.part2;

public class VisibleStudent {

    private int criteria;
    private final int[] heights;
    private int answer = 1;

    public VisibleStudent(int[] heights) {
        this.heights = heights;
        this.criteria = heights[0];
    }

    public boolean isOverThanCriteria(int i) {
        return this.criteria < heights[i];
    }

    public int findVisibleStudentsCount() {
        for(int i=1; i<heights.length; i++){
            if(isOverThanCriteria(i)){
                addVisibleCount();
                changeCriteria(i);
            }
        }
        return answer;
    }

    private void changeCriteria(int index) {
        this.criteria = heights[index];
    }

    private void addVisibleCount(){
        this.answer++;
    };
}
