package ps.inflearntw.part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ps.inflearntw.part1.CompressionString;

import static org.assertj.core.api.Assertions.*;

public class CompressionStringTest {

    @DisplayName("다음 문자와 같은지 판단한다")
    @Test
    public void equalToNextIndex(){
        // given
        CompressionString compression = new CompressionString("KK");

        // when
        Boolean isEqualToNext = compression.isEqualToNext();

        // then
        assertThat(isEqualToNext).isTrue();
    }

    @DisplayName("반복횟수를 1 증가시켜라")
    @Test
    public void addOneWhenEqual(){
        // given
        CompressionString compression = new CompressionString("KK");
        assertThat(compression.getRepeatCount()).isEqualTo(1);

        // when
        compression.addRepeatCount();

        // then
        assertThat(compression.getRepeatCount()).isEqualTo(2);
    }

    @DisplayName("현재 문자와 다음 문자와 다르다면 반복횟수를 초기화하라")
    @Test
    public void initializeRepeatCountWhenDiff(){
        // given
        CompressionString compression = new CompressionString("KS");
        compression.addRepeatCount();
        assertThat(compression.getRepeatCount()).isEqualTo(2);

        // when
        compression.initializeRepeatCount();

        // then
        assertThat(compression.getRepeatCount()).isEqualTo(1);
    }

    @DisplayName("현재 문자와 다음 문자와 다르고 반복횟수가 1번이라면 문자만 추가하라")
    @Test
    public void appendAnswerWhenDiffAndRepeatIs1(){
        // given
        CompressionString compression = new CompressionString("KS");

        // when
        assertThat(compression.getRepeatCount()).isEqualTo(1);
        compression.appendAnswer();

        // then
        assertThat(compression.getAnswer()).isEqualTo("K");
    }

    @DisplayName("현재 문자와 다음 문자와 다르고 반복횟수가 1을 초과하면 문자와 반복횟수를 추가하라")
    @Test
    public void appendAnswerWhenDiffAndRepeatIsOver1(){
        // given
        CompressionString compression = new CompressionString("KK");
        compression.addRepeatCount();

        // when
        assertThat(compression.getRepeatCount()).isEqualTo(2);
        compression.appendAnswer();

        // then
        assertThat(compression.getAnswer()).isEqualTo("K2");

    }

    @DisplayName("문자 전체를 돌며 문자열을 압축하라")
    @Test
    public void inter(){
        // given
        CompressionString compression = new CompressionString("KKHSSSSSSSE");

        // when
        String answer = compression.compression();

        // then
        assertThat(answer).isEqualTo("K2HS7E");
    }
}
