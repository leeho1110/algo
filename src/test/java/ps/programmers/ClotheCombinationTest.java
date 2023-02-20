package ps.programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClotheCombinationTest {

    @Test
    public void test1(){
        // given
        ClotheCombination sut = new ClotheCombination();

        // when
        int result = sut.getMaxComibation(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"},
        });

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void test2(){
        // given
        ClotheCombination sut = new ClotheCombination();

        // when
        int result = sut.getMaxComibation(new String[][]{
                {"blue_sunglasses", "eyewear"},
                {"purple_sunglasses", "eyewear"},
                {"pink_sunglasses", "eyewear"},
                {"yellow_hat", "headgear"},
                {"green_turban", "headgear"},
                {"red_turban", "headgear"},
                {"pp_turban", "headgear"},
                {"ellbow1", "ellbow"}
        });

        // then
        assertThat(result).isEqualTo(39);
    }

}