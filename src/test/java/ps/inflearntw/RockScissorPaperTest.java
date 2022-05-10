package ps.inflearntw;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RockScissorPaperTest {


    @Test
    public void test(){
        // given
        int[] caseOfA = {2, 3, 3, 1, 3};
        int[] caseOfB = {1, 1, 2, 2, 3};
        RockScissorPaper rockScissorPaper = RockScissorPaper.GameReady(caseOfA, caseOfB);

        // when
        List<String> winners = rockScissorPaper.playGame();

        // then
        String result = winners.stream().reduce("", (total, next) -> total + next);
        assertThat(result).isEqualTo("ABABD");
    }
}
