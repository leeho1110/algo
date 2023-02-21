package ps.programmers;

import java.util.*;

public class ClotheCombination {

    public static void main(String[] args) {
        String[][] clothes = new String[][]{
                {"blue_sunglasses", "eyewear"},
                {"purple_sunglasses", "eyewear"},
                {"pink_sunglasses", "eyewear"},
                {"yellow_hat", "headgear"},
                {"green_turban", "headgear"},
                {"red_turban", "headgear"},
                {"pp_turban", "headgear"},
                {"ellbow1", "ellbow"}
        };

        Map<String, Integer> clotheCombination = new HashMap<>();

        for (String[] clothe : clothes) {
            clotheCombination.put(clothe[1], clotheCombination.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 1;
        for (Integer value : clotheCombination.values()) {
            answer *= value+1;
        }
        answer--;
        System.out.println("answer = " + answer);
    }
}
