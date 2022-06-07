package ps.inflearntw.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RankingGetter {
    private int[] scores;
    private List<Integer> rank = new ArrayList<>();

    public RankingGetter(int[] scores) {
        this.scores = scores;
    }

    public static RankingGetter from(int[] ranks) {
        return new RankingGetter(ranks);
    }

    public List<Integer> lineUp() {
        IntStream.range(0, scores.length).forEach(i -> rank.add(compareScore(i)));
        return rank;
    }

    private int compareScore(int input) {
        int rank = 1;

        for (int i = 0; i < scores.length; i++) {
            if (compareTo(input, i)) {
                rank++;
            }
        }
        return rank;
    }

    private boolean compareTo(int index, int i) {
        return scores[i] > scores[index];
    }
}
