package ps.inflearntw.stackandqueue;

import java.util.Stack;

public class PostFixCalculator {
    private final String expression;
    private Stack<Integer> operands = new Stack<>();

    public PostFixCalculator(String expression) {
        this.expression = expression;
    }

    public Integer calculate() {
        // #1. 문자열 전체를 순회 탐색한다.
        for (Character oper : expression.toCharArray()) {
            // #1-1. 숫자라면 스택에 넣고, 연산자라면 아래 비즈니스 로직으로 넘어간다.
            if (Character.isDigit(oper)) {
                operands.push(Character.getNumericValue(oper));
            } else {
                // #2-1. 스택에서 연산할 값 2개를 꺼낸다.
                Integer pop = operands.pop();
                Integer pop2 = operands.pop();

                // #2-2. 연산을 진행하고, 연산의 결과값값을 다시 스택에 넣는다.
                if (oper == '+') {
                    operands.push(pop2 + pop);
                } else if (oper == '-') {
                    operands.push(pop2 - pop);
                } else if (oper == '*') {
                    operands.push(pop2 * pop);
                } else if (oper == '/') {
                    operands.push(pop2 / pop);
                }
            }
        }

        return operands.pop();
    }
}
