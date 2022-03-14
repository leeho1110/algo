package ps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PressKeypadTest {

    private PressKeypad pressKeypad;

    @BeforeEach
    public void init(){
        this.pressKeypad = new PressKeypad();
    }

    @DisplayName("통합 테스트")
    @Test
    public void pressKeyPadIntergrationTest(){

        String testCase1 = pressKeypad.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        String testCase2 = pressKeypad.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
        String testCase3 = pressKeypad.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");


        assertEquals(testCase1, "LRLLLRLLRRL");
        assertEquals(testCase2, "LRLLLRLLRRL");
        assertEquals(testCase3, "LRLLLRLLRRL");
    }
}