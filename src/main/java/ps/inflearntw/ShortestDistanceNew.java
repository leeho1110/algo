package ps.inflearntw;

public class ShortestDistanceNew {

    private String specific;
    private String text;

    private int index;
    private int[] answer;

    public ShortestDistanceNew(String specific, String text){
        this.specific = specific;
        this.text = text;
        answer = new int[text.length()];
    }

    public int[] checkDistance(){
        for(int i=0; i<text.length(); i++){
            if(isEqualToSpecific()){
                putZero();
            } else {
                saveAnswer(getShortestDistance());
            }
            moveIndex();
        }
        return answer;
    }

    private boolean isEqualToSpecific() {
        return String.valueOf(text.charAt(index)).equals(specific);
    }

    private void putZero() {
        answer[index] = 0;
    }

    private int getShortestDistance() {
        String forward = text.substring(index);
        StringBuilder backward = new StringBuilder(text.substring(0, index + 1)).reverse();

        return Math.min(forward.indexOf(specific),Math.abs(backward.indexOf(specific)));
    }

    private int saveAnswer(int distance) {
        return answer[index] = distance;
    }

    private void moveIndex() {
        this.index++;
    }
}
