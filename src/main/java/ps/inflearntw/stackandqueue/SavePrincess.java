package ps.inflearntw.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SavePrincess {

    private final int n;

    public SavePrincess(int n) {
        this.n = n;
    }

    public Integer findLastPrince(int k) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        while(queue.size() > 1){
            for(int i=0; i<k-1; i++){
                queue.add(queue.poll());
            }
            queue.remove();
        }

        return queue.peek();
    }
}
