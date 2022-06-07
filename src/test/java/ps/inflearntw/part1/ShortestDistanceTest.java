package ps.inflearntw.part1;

import org.junit.jupiter.api.Test;
import ps.inflearntw.part1.ShortestDistanceNew;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortestDistanceTest {

    private static ShortestDistanceNew shortestDistance;

    @Test
    public void integration1(){
        String[] inputList = "teachermode e".split(" ");
        shortestDistance = new ShortestDistanceNew(String.valueOf(inputList[1].charAt(0)), inputList[0]);

        int[] answer = {1, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0};
        assertThat(shortestDistance.checkDistance()).isEqualTo(answer);
    }

    @Test
    public void integration2(){
        String[] inputList = "fkdgkjdflkgjljslgjkfldjlkfdg f".split(" ");
        shortestDistance = new ShortestDistanceNew(String.valueOf(inputList[1].charAt(0)), inputList[0]);

        int[] answer = {0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3 ,2 ,1 ,0 ,1, 2, 3, 2, 1, 0, 1, 2};
        assertThat(shortestDistance.checkDistance()).isEqualTo(answer);
    }

    @Test
    public void integration3(){
        String[] inputList = "eochjgoekghlakegh h".split(" ");
        shortestDistance = new ShortestDistanceNew(String.valueOf(inputList[1].charAt(0)), inputList[0]);

        int[] answer = {3, 2, 1, 0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 2, 1, 0};
        assertThat(shortestDistance.checkDistance()).isEqualTo(answer);
    }
}
