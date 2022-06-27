package ps.inflearntw.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    private final String word1;
    private final String word2;
    private Map<Character, Integer> map = new HashMap<>();
    private Map<Character, Integer> map2 = new HashMap<>();

    public Anagram(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
    }

    public StringBuilder check() {
        saveAlphabetAndCount(word1, map);
        saveAlphabetAndCount(word2, map2);
        return validateIsAnagram() ? new StringBuilder("YES") : new StringBuilder("NO");
    }

    private void saveAlphabetAndCount(String word, Map<Character, Integer> map) {
        for (char alphabet : word.toCharArray()) {
            map.put(alphabet, map.getOrDefault(alphabet, 0) + 1);
        }
    }

    private Boolean validateIsAnagram() {
        for (Map.Entry<Character, Integer> alphabet : map.entrySet()) {
            if (!hasKeyOf(alphabet)) {
                return false;
            }
            if (!hasSameCountOf(alphabet)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasSameCountOf(Map.Entry<Character, Integer> entry) {
        return map2.get(entry.getKey()) == map.get(entry.getKey());
    }

    private boolean hasKeyOf(Map.Entry<Character, Integer> alphabet) {
        return map2.containsKey(alphabet.getKey());
    }
}
