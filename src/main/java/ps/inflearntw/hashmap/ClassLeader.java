package ps.inflearntw.hashmap;

import java.util.*;

public class ClassLeader {
    private final String candidates;
    private final Map<String, Integer> voteResult = new LinkedHashMap<>();
    private int max;
    private String winner;

    public ClassLeader(String candidates) {
        this.candidates = candidates;
    }

    public String findWinner() {
        countVoteResult();
        findElected();
        return winner;
    }

    private void findElected() {
        for (String candidate : voteResult.keySet()) {
            compareMaxTo(candidate);
        }
    }

    private void compareMaxTo(String candidate) {
        if (isBiggerThanMax(candidate)) {
            changeMaxValueOf(candidate);
            winner = candidate;
        }
    }

    private void changeMaxValueOf(String candidate) {
        max = voteResult.get(candidate);
    }

    private void countVoteResult() {
        for (String candidate : candidates.split("")) {
            voteResult.put(candidate, voteResult.getOrDefault(candidate, 0) + 1);
        }
    }

    private boolean isBiggerThanMax(String candidate) {
        return voteResult.get(candidate) > max;
    }
}
