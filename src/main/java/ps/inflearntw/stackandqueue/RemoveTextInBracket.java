package ps.inflearntw.stackandqueue;

import java.awt.*;
import java.time.temporal.ChronoField;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class RemoveTextInBracket {


    private final String text;
    private StringBuilder answer = new StringBuilder();

    public RemoveTextInBracket(String text) {
        this.text = text;
    }

    // TODO:
    //  #1. 문자열을 돌며 '('가 나오면 스택에 넣기
    //  #2. 스택에 있는 '('의 크기가 문자열을 돌며 나온 ')'의 크기가 같아질 때까지 answer에 넣지말기
    public String extractNotInBracket() {
        Stack<Character> leftBracketStack = new Stack<>();
        Stack<Character> rightBracketStack = new Stack<>();

        for (Character c : text.toCharArray()) {
            if(c == '('){
                leftBracketStack.push(c);
            } else if(c == ')'){
                rightBracketStack.push(c);
            } else {
                if(leftBracketStack.size() == rightBracketStack.size()){
                    answer.append(c);
                }
            }
        }

        return answer.toString();
    }
}
