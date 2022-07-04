package ps.inflearntw.stackandqueue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostFixCalculatorTest {

/*
    후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
    만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.

    TODO
        #1. 문자열 전체를 순회 탐색한다.
            #1-1. 숫자라면 스택에 넣는다. ex)위 예시대로라면 3 5 2(top) 순으로 들어갈 것
            #1-2. 연산자라면 아래 비즈니스 로직으로 넘어간다.
        #2. 연산자를 찾은 경우
            #2-1. 스택에서 연산할 값 2개를 꺼낸다.
            #2-2. 연산을 완료한 값을 다시 스택에 넣는다.
*/

    @Test
    public void test1(){
        // given
        PostFixCalculator sut = new PostFixCalculator("352+*9-");

        // when
        Integer result = sut.calculate();

        // then
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void test2(){
        // given
        PostFixCalculator sut = new PostFixCalculator("573*+5-323*++");

        // when
        Integer result = sut.calculate();

        // then
        assertThat(result).isEqualTo(30);
    }
}