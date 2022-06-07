package ps.inflearntw.part2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintBiggerTest {

    @Test
    @DisplayName("바로 앞 수보다 큰지를 확인한다.")
    public void testBiggerThatPrev(){
        // given
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(7);
        numbers.add(3);
        numbers.add(9);
        numbers.add(5);
        numbers.add(6);
        numbers.add(12);

        PrintBigger printBigger = new PrintBigger(numbers);

        // when
        boolean biggerThanPrev = printBigger.isBiggerThanPrev(1);

        // then
        assertThat(biggerThanPrev).isFalse();
    }

    @Test
    @DisplayName("통합 테스트")
    public void inter(){
        // given
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(7);
        numbers.add(3);
        numbers.add(9);
        numbers.add(5);
        numbers.add(6);
        numbers.add(12);
        PrintBigger printBigger = new PrintBigger(numbers);

        // when
        String answer = printBigger.printBigger();

        // then
        assertThat(answer).isEqualTo("7 9 6 12");
    }
}
