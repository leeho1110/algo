package ps.inflearntw.part2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SameClassTest {

    private int[][] students;

    @BeforeEach
    public void setUp(){
        students = new int[5][5];
    }

    @Test
    public void integration(){

        // given
        students[0] = new int[]{2,3,1,7,3}; // 0,0,0,0,0 = 0
        students[1] = new int[]{4,1,9,6,8}; // 0,0,0,1,0 = 1
        students[2] = new int[]{5,5,2,4,4}; // 0,1,2,0,0 = 3
        students[3] = new int[]{6,5,2,6,7}; // 0,1,2,1,0 = 4
        students[4] = new int[]{8,4,2,2,2}; // 0,2,0,0,0 = 2
        SameClass sameClass = SameClass.of(students);

        // when
        Integer result = sameClass.getTempLeader();

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void integration2(){
        // given
        students[0] = new int[]{9, 8, 7, 6, 5}; // 0,0,1,0,0 = 1
        students[1] = new int[]{5, 6, 7, 8, 9}; // 0,0,1,0,0 = 1
        students[2] = new int[]{1, 2, 3, 7, 8}; // 0,1,1,0,0 = 2
        students[3] = new int[]{4, 5, 3, 4, 2}; // 0,0,1,1,1 = 3
        students[4] = new int[]{6, 2, 8, 4, 2}; // 0,1,0,1,1 = 3
        SameClass sameClass = SameClass.of(students);

        // when
        Integer result = sameClass.getTempLeader();

        // then
        assertThat(result).isEqualTo(4);
    }
}
