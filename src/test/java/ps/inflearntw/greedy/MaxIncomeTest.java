package ps.inflearntw.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxIncomeTest {

    @Test
    public void test() {
        // given
        MaxIncome sut = new MaxIncome();

        // when
        int result = sut.findMax(Arrays.asList(
                new MaxIncome.Lecture(50, 2),
                new MaxIncome.Lecture(20, 1),
                new MaxIncome.Lecture(40, 2),
                new MaxIncome.Lecture(60, 3),
                new MaxIncome.Lecture(30, 3),
                new MaxIncome.Lecture(30, 1)
        ));

        // then
        assertEquals(result, 140);
    }
}