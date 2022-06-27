package ps.inflearntw.hashmap;

import java.util.*;

public class TypeOfRevenue {
    private final int period;
    private final int[] revenues;
    private List<Integer> answer = new LinkedList<>();
    private int lt;
    private int rt;
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TypeOfRevenue(int[] revenues, int period) {
        this.revenues = revenues;
        this.period = period;
    }

    public int[] findTypeInPeriod() {
        for(rt=0; rt<period-1; rt++){
            map.put(revenues[rt], map.getOrDefault(revenues[rt],0)+1);
        }

        for(; rt<revenues.length; rt++){
            map.put(revenues[rt], map.getOrDefault(revenues[rt],0)+1);

            answer.add(map.size());

            map.put(revenues[lt], map.get(revenues[lt]) - 1);
            if(map.get(revenues[lt]) == 0){
                map.remove(revenues[lt]);
            }
            lt++;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
