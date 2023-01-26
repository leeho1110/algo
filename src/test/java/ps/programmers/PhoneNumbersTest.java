package ps.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumbersTest {

    @Test
    public void test(){
        // given
        PhoneNumbers sut = new PhoneNumbers();

        // when
        boolean result = sut.solution(new String[]{"119", "97674223", "1195524421"});

        // then
        assertEquals(result, false);
    }

    @Test
    public void test1(){
        // given
        PhoneNumbers sut = new PhoneNumbers();

        // when
        boolean result = sut.solution(new String[]{"123","456","789"});

        // then
        assertEquals(result, true);
    }

    @Test
    public void test2(){
        // given
        PhoneNumbers sut = new PhoneNumbers();

        // when
        boolean result = sut.solution(new String[]{"12","123","1235","567","88"});

        // then
        assertEquals(result, false);
    }

}