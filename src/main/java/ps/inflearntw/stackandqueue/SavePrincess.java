package ps.inflearntw.stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class SavePrincess {

    private final int n;
    private final Queue<Integer> princes = new ArrayDeque<>();

    public SavePrincess(int n) {
        this.n = n;
    }

    public Integer findLastPrince(int k) {
        lineUpPrices();
        removePriceEvery3time(k);
        return princes.peek();
    }

    private void lineUpPrices() {
        for (int i = 0; i < n; i++) {
            princes.add(i + 1);
        }
    }

    private void removePriceEvery3time(int k) {
        while(hasLeftOnlyOne()){
            for(int i = 0; i< k -1; i++){
                princes.add(princes.poll());
            }
            princes.remove();
        }
    }

    private boolean hasLeftOnlyOne() {
        return princes.size() > 1;
    }
}
