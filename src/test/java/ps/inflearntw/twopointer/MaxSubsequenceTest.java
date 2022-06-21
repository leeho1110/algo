package ps.inflearntw.twopointer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSubsequenceTest {

    // 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
    // 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.

    @Test
    public void integration(){
        // given
        MaxSubsequence sut = new MaxSubsequence(new int[]{1,1,0,0,1,1,0,1,1,0,1,1,0,1},2);

        // when
        int result = sut.findMaxLengthOfSequence();

        // then
        assertThat(result).isEqualTo(8);
    }

}