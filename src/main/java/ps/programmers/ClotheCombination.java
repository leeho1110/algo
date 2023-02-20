package ps.programmers;

import java.util.*;

public class ClotheCombination {

    public int getMaxComibation(String[][] clothes){
        Map<String, Integer> clotheCombination = new HashMap<>();

        for (String[] clothe : clothes) {
            clotheCombination.put(clothe[1], clotheCombination.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 1;
        for (Integer clotheAmount : clotheCombination.values()) {
            answer *= clotheAmount+1;
        }
        answer--;

        return answer;
    }
}
