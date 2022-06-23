package ps.inflearntw.hashmap;

import java.util.*;

public class ClassLeader {
    private final String candidates;
    private final Map<Character, Integer> voteResult = new LinkedHashMap<>();
    private int max;
    private Character winner;

    public ClassLeader(String candidates) {
        this.candidates = candidates;
    }

    public Character findWinner() {
        countVoteResult();
        findElected();
        return winner;
    }

    private void findElected() {
        for (Map.Entry<Character, Integer> candidate : voteResult.entrySet()) {
            compareMaxTo(candidate.getKey());
        }
    }

    private void compareMaxTo(Character candidate) {
        if (isBiggerThanMax(candidate)) {
            changeMaxValueOf(candidate);
            winner = candidate;
        }
    }

    private void changeMaxValueOf(Character candidate) {
        max = voteResult.get(candidate);
    }

    private void countVoteResult() {
        for (Character candidate : candidates.toCharArray()) {
            voteResult.put(candidate, voteResult.getOrDefault(candidate, 0) + 1);
        }
    }

    private boolean isBiggerThanMax(Character candidate) {
        return voteResult.get(candidate) > max;
    }
}
