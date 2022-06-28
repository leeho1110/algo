package ps.inflearntw.hashmap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EveryAnagramFinderTest {

    /*
      문제: S 문자열에서 T 문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
      아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

      Q. bacaAacba / abc
      A. bac, acb, cba
    */

    @Test
    public void integration(){
        // given
        String s = "bacaAacba";
        String t = "abc";
        EveryAnagramFinder sut = EveryAnagramFinder.of(s,t);

        // when
        Integer result = sut.find();

        // then
        assertThat(result).isEqualTo(3);
    }
}