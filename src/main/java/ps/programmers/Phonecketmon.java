package ps.programmers;

import java.util.HashSet;
import java.util.Set;

public class Phonecketmon {

    private int halfOfNums;

    public int solution(int[] nums) {
        this.halfOfNums = nums.length / 2;
        Set<Integer> poketmons = new HashSet<>();

        for(int pocketmon: nums){
            poketmons.add(pocketmon);

            if(isOverThanHalfOfN(poketmons)){
                return poketmons.size();
            }
        }

        return poketmons.size();
    }

    private boolean isOverThanHalfOfN(Set poketmons){
        return poketmons.size() == halfOfNums;
    }
}
