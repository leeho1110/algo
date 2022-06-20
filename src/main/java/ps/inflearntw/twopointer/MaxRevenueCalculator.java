package ps.inflearntw.twopointer;

import java.util.Arrays;

public class MaxRevenueCalculator {
    private final int[] revenues;
    private int period;
    private int answer = 0;
    private int startPointer = 0;

    public MaxRevenueCalculator(int[] revenues, int period) {
        this.revenues = revenues;
        this.period = period;
    }

    public static MaxRevenueCalculator of(int[] revenues, int period) {
        return new MaxRevenueCalculator(revenues, period);
    }

    public int findMaxRevenue() {
        // 배열을 돌며
        int baseRevenue = calculateBaseRevenue();
        compareSumForPeriodTo(baseRevenue);
        return answer;
    }

    private void compareSumForPeriodTo(int sumInPeriod) {
        for(int i=period; i<revenues.length; i++){
            sumInPeriod = calculateSumInNextPeriod(sumInPeriod);
            changeAnswerToBiggerFrom(sumInPeriod);
        }
    }

    private int calculateSumInNextPeriod(int sumInPeriod) {
        return sumInPeriod + (revenues[period++] - revenues[startPointer++]);
    }

    private void changeAnswerToBiggerFrom(int baseRevenue) {
        answer = Math.max(answer, baseRevenue);
    }

    private int calculateBaseRevenue() {
        return Arrays.stream(revenues, 0, period).sum();
    }
}
