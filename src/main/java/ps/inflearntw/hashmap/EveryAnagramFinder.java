package ps.inflearntw.hashmap;

import java.util.HashMap;
import java.util.Map;

public class EveryAnagramFinder {

    private final String s;
    private final String t;

    private Integer leftPtr = 0;
    private Integer rightPtr = 0;
    private Integer answer = 0;
    private final Map<Character, Integer> compareCase = new HashMap<>();
    private final Map<Character, Integer> target = new HashMap<>();

    public EveryAnagramFinder(String s, String t) {
        this.s = s;
        this.t = t;
    }

    public static EveryAnagramFinder of(String s, String t) {
        return new EveryAnagramFinder(s, t);
    }

    public Integer find() {
        createComparisonTarget();
        readyForFind();
        findAnagramCase();
        return answer;
    }

    private void createComparisonTarget() {
        for (Character character : t.toCharArray()) {
            target.put(character, target.getOrDefault(character, 0) + 1);
        }
    }

    private void readyForFind() {
        for (int i = 0; i < t.length() - 1; i++) {
            compareCase.put(s.charAt(i), compareCase.getOrDefault(s.charAt(i), 0) + 1);
        }
    }

    private void findAnagramCase() {
        for (rightPtr = t.length() - 1; rightPtr < s.length(); rightPtr++) {
            mergeValueOfRightPtrOnCompareCase();
            if (isEqualToTarget()) {
                answer++;
            }

            subtractValueOfLeftPointerOnCompareCase();
            if (hasNotContain(s.charAt(leftPtr))) {
                compareCase.remove(s.charAt(leftPtr));
            }
            leftPtr++;
        }
    }

    private void mergeValueOfRightPtrOnCompareCase() {
        compareCase.put(s.charAt(rightPtr), compareCase.getOrDefault(s.charAt(rightPtr), 0) + 1);
    }

    private Boolean isEqualToTarget() {
        Boolean equalFlag = Boolean.TRUE;

        for (Map.Entry<Character, Integer> entry : compareCase.entrySet()) {
            if (isNotContainKeyOf(entry)) {
                equalFlag = Boolean.FALSE;
            }

            if (isNotEqualToValueOf(entry)) {
                equalFlag = Boolean.FALSE;
            }
        }

        return equalFlag;
    }

    private boolean isNotEqualToValueOf(Map.Entry<Character, Integer> entry) {
        return !(target.get(entry.getKey()) == entry.getValue());
    }

    private boolean isNotContainKeyOf(Map.Entry<Character, Integer> entry) {
        return !target.containsKey(entry.getKey());
    }

    private void subtractValueOfLeftPointerOnCompareCase() {
        compareCase.put(s.charAt(leftPtr), compareCase.get(s.charAt(leftPtr)) - 1);
    }

    private boolean hasNotContain(Character valueOfLeftPtr) {
        return compareCase.get(valueOfLeftPtr) == 0;
    }
}
