package ps.inflearntw.part1;

import org.junit.jupiter.api.Test;
import ps.inflearntw.part1.RevertWord;

import static org.assertj.core.api.Assertions.assertThat;

class RevertWordTest {

    private RevertWord revertWord = new RevertWord();

    @Test
    void revertSpellTest(){
        String revertedWord = revertWord.revertSpell("pleaseRevert");
        assertThat(revertedWord).isEqualTo("treveResaelp");
    }
}