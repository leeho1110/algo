package ps.inflearntw.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Anagram {
    private final String word1;
    private final String word2;

    public Anagram(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
    }

    public StringBuilder validateIsAnagram() {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char alphabet : word1.toCharArray()) {
            map.put(alphabet, map.getOrDefault(alphabet,0)+1);
        }

        for (char alphabet : word2.toCharArray()) {
            map2.put(alphabet, map2.getOrDefault(alphabet,0)+1);
        }

        Boolean flag = true;
        for (Character alphabet : map.keySet()) {
            if(!map2.containsKey(alphabet)){
                flag = false;
            } else {
                if((!(map2.get(alphabet) == map.get(alphabet)))){
                    flag = false;
                }
            }
        }

        return flag ? new StringBuilder("YES") : new StringBuilder("NO");
    }
}
