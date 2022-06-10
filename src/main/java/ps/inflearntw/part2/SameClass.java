package ps.inflearntw.part2;

public class SameClass {
    private int[][] students;
    private int[] scores;

    public SameClass(int[][] students) {
        this.students = students;
        scores = new int[students.length];
    }

    public static SameClass of(int[][] students) {
        return new SameClass(students);
    }

    public Integer getTempLeader() {
        for(int i=0; i<students.length; i++){
            scores[i] = getSameCountOf(i);
        }

        return findWhoIsHighestCount()+1;
    }

    private int getSameCountOf(int me) {
        int count = 0;
        for(int i=0; i<students.length; i++){
            for(int j=0; j<5; j++){
                System.out.print(String.format("%s vs %s = %b /", students[me][i], students[j][i],students[me][i] == students[j][i]));
                if(students[me][i] == students[j][i]){
                    count++;
                }
            }
            System.out.println();
        }
        System.out.println();
        return count-5;
    }

    private int findWhoIsHighestCount() {
        int maxIdx = 0;
        for(int i=0; i<scores.length; i++){
            System.out.println(scores[i]);
            if(isBiggerThan(maxIdx, i)){
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private boolean isBiggerThan(int maxIdx, int i) {
        return scores[i] > scores[maxIdx];
    }
}
