package ps.inflearntw.twopointer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxRevenueTest {

/*
    현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
    만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면, 12 15 {11 20 25} 10 20 19 13 15
    연속된 3일간의 최대 매출액은 11+20+25=56만원입니다. 여러분이 현수를 도와주세요.
*/

    @Test
    public void integration(){
        // given
        MaxRevenueCalculator maxRevenueCal = MaxRevenueCalculator.of(new int[]{12, 15, 11, 20, 25, 10, 20, 19, 13, 15}, 3);
        MaxRevenueCalculator maxRevenueCal2 = MaxRevenueCalculator.of(new int[]{100, 15, 11, 20, 25, 10, 20, 19, 13, 15}, 3);

        // when
        int result = maxRevenueCal.findMaxRevenue();
        int result2 = maxRevenueCal2.findMaxRevenue();

        // then
        assertThat(result).isEqualTo(56);
        assertThat(result2).isEqualTo(126);
    }
}
