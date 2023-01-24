package ps.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonecketmonTest {

    @Test
    public void test(){
        // given
        Phonecketmon sut = new Phonecketmon();
        int[] nums = {3,1,2,3};

        // when
        int result = sut.solution(nums);

        // then
        assertEquals(result,2);
    }
}