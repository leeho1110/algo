package ps.inflearntw;

public class SerialScoreCalculator {
    private int[] scores;
    private int point = 1;
    private int totalScore;

    public SerialScoreCalculator(int[] scores) {
        setScores(scores);
    }

    public static SerialScoreCalculator from(int[] scores) {
        return new SerialScoreCalculator(scores);
    }

    public int calculateTotalScore() {
        for(int i=0; i<scores.length; i++){
            if(isCorrect(i)){
                addTotalScore();
                addExtraPoint();
            } else {
                initializePoint();
            }
        }

        return totalScore;
    }

    private void initializePoint() {
        point = 1;
    }

    private void addExtraPoint() {
        point++;
    }

    private void addTotalScore() {
        totalScore += point;
    }

    private boolean isCorrect(int i) {
        return scores[i] == 1;
    }

    private void setScores(int[] scores) {
        this.scores = scores;
    }
}
