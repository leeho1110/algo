package ps.inflearntw.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class KthLargestNumber {

    private Integer answer = -1;

    private TreeSet<Integer> sums = new TreeSet<>(Collections.reverseOrder());

    public Integer find(int[] cards, int k) {
        findSums(cards);
        findKth(k);
        return answer;
    }

    private void findKth(int k) {
        int count = 1;
        for (Integer sum : sums) {
            if (count == k){
                this.answer = sum;
            }
            count++;
        }
    }

    private void findSums(int[] cards) {
        for(int i = 0; i< cards.length; i++){
            for(int j = i+1; j< cards.length; j++){
                for(int l = j+1; l< cards.length; l++){
                    sums.add(cards[i]+ cards[j]+ cards[l]);
                }
            }
        }
    }
}
