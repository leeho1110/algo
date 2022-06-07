package ps.inflearntw.part2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VisibleStudentTest {

    // 전체를 탐색한다.
    // 1번을 기준으로 잡는다.
    // 1번보다 높은 사람을 발견할 때까지 탐색한다.
    // 높은 사람을 발견하면 정답에 1을 더한다.
    // 높은 사람이 되면 기준을 변경한다.

    @Test
    public void testGetHighest(){
        // given
        int[] input = {23, 10, 46, 62, 42, 39, 11, 98, 71, 41};
        VisibleStudent visibleStudent = new VisibleStudent(input);
        List<Boolean> answer = new ArrayList<>();

        // when
        for(int i=1; i<input.length; i++){
            answer.add(visibleStudent.isOverThanCriteria(i));
        }

        // then
        assertThat(answer).containsExactly(false, true, true, true, true, false, true, true, true);
    }

    @Test
    public void intergration(){
        // given
        int[] input = {23, 10, 46, 62, 42, 39, 11, 98, 71, 41};
        VisibleStudent visibleStudent = new VisibleStudent(input);

        // when
        int answer = visibleStudent.findVisibleStudentsCount();

        // then
        assertThat(answer).isEqualTo(4);
    }

}
