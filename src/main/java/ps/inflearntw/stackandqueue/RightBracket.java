package ps.inflearntw.stackandqueue;

import java.util.Stack;

public class RightBracket {

    public static final String YES = "YES";
    public static final String NO = "NO";
    private final String brackets;
    private Stack<String> bracketStack = new Stack<>();

    public RightBracket(String brackets) {
        this.brackets = brackets;
    }

    public String validate() {
        for (Character bracket : brackets.toCharArray()) {
            // #1. 왼쪽이 들어오면 스택에 넣기
            if(isRightBracket(bracket)){
                bracketStack.push(brackets);
            }
            // #2. 오른쪽이 들어오면 유효성 검사 시작
            else {
                // #2.1 정상적인 경우라면 왼쪽이 이미 존재해야한다. 하지만 비어있다면 비정상
                if (isEmpty()) {
                    return NO;
                }
                // #2.2 비어있지 않다면 다음 차수를 위해 '('를 꺼내버리기
                else {
                    bracketStack.pop();
                }
            }
        }

        // #3. 남아있는 '('가 있는지 체크
        if(hasLeftoverBracket()){
            return NO;
        }
        
        return YES;
    }

    private boolean hasLeftoverBracket() {
        return !bracketStack.isEmpty();
    }

    private boolean isEmpty() {
        return bracketStack.isEmpty();
    }

    private boolean isRightBracket(Character bracket) {
        return bracket == '(';
    }
}
