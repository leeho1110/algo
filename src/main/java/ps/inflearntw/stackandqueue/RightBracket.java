package ps.inflearntw.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            if (isStartOfBracket(bracket)) {
                bracketStack.push(brackets);
            } else {
                if (bracketStack.isEmpty()) {
                    return NO;
                } else {
                    bracketStack.pop();
                };
            }
        }

        if (hasRemainBracket()) {
            return NO;
        }

        return YES;
    }

    private boolean hasRemainBracket() {
        return !bracketStack.isEmpty();
    }

    private boolean isStartOfBracket(Character bracket) {
        return bracket == '(';
    }
}
