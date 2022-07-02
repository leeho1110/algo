package ps.inflearntw.stackandqueue;

import java.util.Stack;

public class RemoveTextInBracket {
    private final String text;
    private StringBuilder answer = new StringBuilder();
    private Stack<Character> leftBracketStack = new Stack<>();
    private Stack<Character> rightBracketStack = new Stack<>();

    public RemoveTextInBracket(String text) {
        this.text = text;
    }

    // TODO:
    //  #1. 문자열을 돌며 '('가 나오면 스택에 넣기
    //  #2. 스택에 있는 '('의 크기가 문자열을 돌며 나온 ')'의 크기가 같아질 때까지 answer에 넣지말기
    public String extractNotInBracket() {
        for (Character c : text.toCharArray()) {
            findCharacterNotInBracket(c);
        }
        return answer.toString();
    }

    private void findCharacterNotInBracket(Character c) {
        if(isBracket(c)){
            pushToBracketStack(c);
        } else {
            if(hasBracketStackSameSize()){
                answer.append(c);
            }
        }
    }

    private boolean hasBracketStackSameSize() {
        return leftBracketStack.size() == rightBracketStack.size();
    }

    private void pushToBracketStack(Character c) {
        if (c == '(') {
            leftBracketStack.push(c);
        } else {
            rightBracketStack.push(c);
        }
    }

    private boolean isBracket(Character c) {
        return c == '(' || c == ')';
    }
}
