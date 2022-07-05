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
            if(bar[i] == '('){
                barBasket.push(bar[i]);
            } else {
                if(i != 0 && bar[i-1] == '('){
                    barBasket.pop();
                    answer += barBasket.size();
                } else {
                    barBasket.pop();
                    answer++;
                }
            }
        }
        return answer;
    }
}
