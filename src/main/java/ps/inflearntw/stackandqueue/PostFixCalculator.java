package ps.inflearntw.stackandqueue;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.BiFunction;

public class PostFixCalculator {
    private final String expression;
    private Stack<Integer> operands = new Stack<>();

    public PostFixCalculator(String expression) {
        this.expression = expression;
    }

    public Integer calculate() {
        // #1. 문자열 전체를 순회 탐색한다.
        for (Character ele : expression.toCharArray()) {
            // #1-1. 숫자라면 스택에 넣고, 연산자라면 아래 비즈니스 로직으로 넘어간다.
            pushOrCalculate(ele);
        }
        return operands.pop();
    }

    private void pushOrCalculate(Character ele) {
        if (Character.isDigit(ele)) {
            pushToOperands(ele);
        } else {
            calculatePostFix(ele);
        }
    }

    private void pushToOperands(Character ele) {
        operands.push(Character.getNumericValue(ele));
    }

    private void calculatePostFix(Character ele) {
        // #2-1. 스택에서 연산할 값 2개를 꺼낸다.
        Integer rightOperand = operands.pop();
        Integer leftOperand = operands.pop();

        // #2-2. 연산을 진행하고, 연산의 결과값값을 다시 스택에 넣는다.
        if (ele == '+') {
            operands.push(leftOperand + rightOperand);
        } else if (ele == '-') {
            operands.push(leftOperand - rightOperand);
        } else if (ele == '*') {
            operands.push(leftOperand * rightOperand);
        } else if (ele == '/') {
            operands.push(leftOperand / rightOperand);
        }
    }

    enum Operator {
        ADD('+', (num1, num2) -> num1 + num2),
        MINUS('-', (num1, num2) -> num1 - num2),
        MULTIPLY('*', (num1, num2) -> num1 * num2),
        DIVIDE('/', (num1, num2) -> num1 / num2);

        private final Character symbol;
        private final BiFunction<Integer, Integer, Integer> expression;

        Operator(Character symbol, BiFunction<Integer, Integer, Integer> expression) {
            this.symbol = symbol;
            this.expression = expression;
        }

        public Character getSymbol() {
            return this.symbol;
        }

        public BiFunction<Integer, Integer, Integer> getExpression() {
            return this.expression;
        }

        public Integer calculate(Integer num1, Integer num2) {
            return getExpression().apply(num1, num2);
        }

        public static Operator findOperatorBy(Character symbol) {
            return Arrays.stream(values())
                    .filter(operator -> operator.getSymbol() == symbol)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 연산사 symbol입니다!"));
        }
    }
}
