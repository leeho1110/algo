package ps.inflearntw.hashmap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EveryAnagramFinderTest {

    /*
      문제: S 문자열에서 T 문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
      아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

      Q. bacaAacba / abc
      A. bac, acb, cba

     TODO:
      #1: S 문자열에서 T 문자열 바로 전까지 우선 미리 넣어놓는다.
      #2: T 문자열의 마지막 위치에 RT를 첫번째 자리에 LT를 배치
      #3: 슬라이딩 윈도우 방식으로 계속 RT가 글자의 끝에 돌 때까지 아나그램인지 여부를 확인하기
      #4: 아나그램이라면 +1, 그런데 기존에 있는 경우라면 +0을 해야한다. 따라서 정답은 Set 자료구조를 사용하는 것이 좋다.
    */

    @Test
    public void integration(){
        // given
        String s = "bacaAacba";
        String t = "abc";
        EveryAnagramFinder sut = new EveryAnagramFinder(s,t);

        // when
        Integer result = sut.findAllOf();

        // then
        assertThat(result).isEqualTo(3);
    }
}