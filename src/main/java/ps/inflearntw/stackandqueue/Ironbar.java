package ps.inflearntw.stackandqueue;

import java.util.Stack;

public class Ironbar {
    private final char[] bar;
    private Stack<Character> barBasket = new Stack<>();
    private int answer;

    public Ironbar(String bar) {
        this.bar = bar.toCharArray();
    }

    public Integer getSlicedBarCount() {
        for(int i=0; i<bar.length; i++){
            if(isLeftBracket(i)){
                barBasket.push(bar[i]);
            } else {
                countSlicedBar(i);
            }
        }
        return answer;
    }

    private boolean isLeftBracket(int i) {
        return bar[i] == '(';
    }

    private void countSlicedBar(int i) {
        if(isLeftBracket(i - 1)){
            barBasket.pop();
            answer += barBasket.size();
        } else {
            barBasket.pop();
            answer++;
        }
    }
}
