package ps.inflearntw.part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DecryptionTest {

    @Test
    @DisplayName("문자를 7자리마다 나눠라")
    public void testSplitPassword(){
        // given
        String password = "#****###**#####**#####**##**";
        int count = 4;

        // when
        Decryption of = Decryption.of(password, count);

        // then
        assertThat(of.getCryptos()).containsExactly("#****##","#**####","#**####","#**##**");
    }

    @Test
    @DisplayName("#은 1로, *은 0으로 변환한다")
    public void testConvert(){
        // given
        Decryption of = Decryption.of("#****###**#####**#####**##**", 4);

        // when
        of.convertSpecialToBinary();

        // then
        List<String> binary = of.getBinaries();
        assertThat(binary).containsExactly("1000011", "1001111", "1001111","1001100");
    }

    @Test
    @DisplayName("2진수를 10진수화하라")
    public void testBinaryToTen(){
        // given
        Decryption of = Decryption.of("#****###**#####**#####**##**", 4);

        // when
        of.convertSpecialToBinary();
        of.convertBinaryToDecimal();
        List<Integer> decimal = of.getDecimals();

        // then
        assertThat(of.getDecimals()).containsExactly(67,79,79,76);
    }

    @Test
    @DisplayName("통합 테스트")
    public void inter(){
        // given
        Decryption of = Decryption.of("#****###**#####**#####**##**", 4);

        // when
        String answer = of.decryption();

        // then
        assertThat(answer).isEqualTo("COOL");
    }
}
