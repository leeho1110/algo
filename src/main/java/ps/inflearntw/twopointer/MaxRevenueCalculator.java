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
        calculateBaseRevenue();
        compareSumForPeriodTo();
        return answer;
    }

    private void compareSumForPeriodTo() {
        int baseSum = answer;
        for (int i = period; i < revenues.length; i++) {
            baseSum = calculateSumInNextPeriod(baseSum);
            changeAnswerToBiggerFrom(baseSum);
        }
    }

    private int calculateSumInNextPeriod(int sumInPeriod) {
        return sumInPeriod + (revenues[period++] - revenues[startPointer++]);
    }

    private void changeAnswerToBiggerFrom(int baseRevenue) {
        answer = Math.max(answer, baseRevenue);
    }

    private void calculateBaseRevenue() {
        // 799ms
        int temp = 0;
        for (int i = 0; i < period; i++) {
            temp += revenues[i];
        }
        this.answer = temp;

        // 시간 초과 발생 (1028ms)
        // answer = Arrays.stream(revenues, 0, period).sum();
    }
}
