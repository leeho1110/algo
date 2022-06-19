package ps.inflearntw.twopointer;

import org.junit.jupiter.api.Test;
import ps.inflearntw.twopointer.FindCommonElement;

import static org.assertj.core.api.Assertions.assertThat;

class FindCommonElementTest {

//    첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
//    두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
//    세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
//    네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
//
//    각 집합의 원소는 1,000,000,000이하의 자연수입니다.
//      두 집합의 공통원소를 오름차순 정렬하여 출력합니다.

    // 1 3 9 5 2
    // 3 2 5 7 8

    // 포인터 비교를 시작
    // 만약 같다? 그렇다면 정답에 넣기
    // 그리고 오름차순이기 때문에 작은 쪽을 넘기는거지



    @Test
    public void test_getSystemInput(){
        // given
        int[] stub = new int[]{2,3,5};
        FindCommonElement sut = FindCommonElement.of(new int[]{1,3,9,5,2}, new int[]{3,2,5,7,8});

        // when
        int[] result = sut.findCommonElement();

        // then
        assertThat(result).containsExactly(stub);
    }
}