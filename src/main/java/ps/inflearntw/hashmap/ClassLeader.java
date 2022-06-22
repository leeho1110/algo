package ps.inflearntw.hashmap;

import java.util.*;

public class ClassLeader {
    private final String candidates;
    private int max;
    private String winner;

    public ClassLeader(String candidates) {
        this.candidates = candidates;
    }

    public String findWinner() {
        Map<String, Integer> voteResult = new LinkedHashMap<>();

        for (String candidate : candidates.split("")) {
            voteResult.put(candidate, voteResult.getOrDefault(candidate, 1)+1);
        }

        for( String candidate : voteResult.keySet()){
            if(voteResult.get(candidate) > max){
                max = voteResult.get(candidate);
                winner = candidate;
            }
        }
        
        return winner;
    }
}
