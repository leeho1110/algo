package ps.inflearntw.hashmap;

import java.util.*;

public class RevenueCategoryCalculator {
    private final int period;
    private final int[] revenues;
    private List<Integer> answer = new LinkedList<>();
    private int lt;
    private int rt;
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public RevenueCategoryCalculator(int[] revenues, int period) {
        this.revenues = revenues;
        this.period = period;
    }

    public int[] calculateRevenueCategory() {
        findUntilPeriod();
        findInRemaining();
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void findInRemaining() {
        for (; rt < revenues.length; rt++) {
            findRevenueCategory();
            addAnswer();
            processOfLeftPointer();
        }
    }

    private void findRevenueCategory() {
        map.put(revenues[rt], map.getOrDefault(revenues[rt], 0) + 1);
    }

    private void addAnswer() {
        answer.add(map.size());
    }

    private void processOfLeftPointer() {
        map.put(revenues[lt], map.get(revenues[lt]) - 1);
        if (isCannotFound()) {
            map.remove(revenues[lt]);
        }
        lt++;
    }

    private boolean isCannotFound() {
        return map.get(revenues[lt]) == 0;
    }

    private void findUntilPeriod() {
        for (rt = 0; rt < period - 1; rt++) {
            map.put(revenues[rt], map.getOrDefault(revenues[rt], 0) + 1);
        }
    }
}
