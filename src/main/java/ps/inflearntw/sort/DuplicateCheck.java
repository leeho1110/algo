package ps.inflearntw.sort;

import java.util.HashMap;

public class DuplicateCheck {
    public static final String DUPLICATION = "D";
    public static final String UNIQUE = "U";
    private final int[] numbers;
    private HashMap<Integer, Integer> basket = new HashMap<>();

    public DuplicateCheck(int[] numbers) {
        this.numbers = numbers;
    }

    public String validate() {
        for (int number : numbers) {
            if(basket.containsKey(number)){
                return DUPLICATION;
            }
            basket.put(number,0);
        }
        return UNIQUE;
    }
}
