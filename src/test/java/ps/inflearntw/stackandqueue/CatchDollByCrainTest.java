package ps.inflearntw.stackandqueue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class CatchDollByCrainTest {

/*
    크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
    또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. (그림에서는 화면표시 제약으로 5칸만으로 표현하였음)
    게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
    크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.

    TODO
        #1. 크레인의 이동 동선을 순회탐색
            #1-1. 크레인의 위치에서 0이 아닌 인형이 나올 때까지 탐색
            #1-2. 인형이 나오면 임시 지역 변수에 저장
            #1-3. 해당 위치의 인형을 꺼냈으니 0(빈칸)으로 초기화
            #1-4. 인형을 찾았으니 탐색 중지(break)
        #2. 찾은 인형과 기존에 탐색한 인형의 최상단과 비교
            #2-1. 인형이 빈칸이라면 skip
            #2-2. 만약 최상단과 다르면 push
            #2-3. 최상단과 일치하면 인형 터뜨리기(answer + 2)
 */
    
    @Test
    public void test(){
        // given
        int[] dolls1 = new int[]{0,0,0,4,3};
        int[] dolls2 = new int[]{0,0,2,2,5};
        int[] dolls3 = new int[]{0,1,5,4,1};
        int[] dolls4 = new int[]{0,0,0,4,3};
        int[] dolls5 = new int[]{0,3,1,2,1};

        int[][] basket = new int[][]{dolls1,dolls2,dolls3,dolls4,dolls5};
        int[] moves = new int[]{1,5,3,5,1,2,1,4};

        CatchDollByCrain sut = new CatchDollByCrain(basket, moves);

        // when
        Integer result = sut.play();

        // then
        assertThat(result).isEqualTo(4);
    }
}