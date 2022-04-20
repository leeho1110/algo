package ps.inflearntw;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortestDistanceTest {

    private static ShortestDistanceNew shortestDistance;

    @BeforeAll
    public static void setUp(){
        String[] inputList = "teachermode e".split(" ");
        shortestDistance = new ShortestDistanceNew(String.valueOf(inputList[1].charAt(0)), inputList[0]);
    }

    @Test
    public void integration(){
        int[] answer = {1, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0,};
        assertThat(shortestDistance.checkDistance()).isEqualTo(answer);
    }
}
