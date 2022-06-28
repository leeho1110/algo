package ps.inflearntw.hashmap;

import java.util.HashMap;
import java.util.Map;

public class EveryAnagramFinder {

    private final String s;
    private final String t;

    private Integer leftPtr = 0;
    private Integer rightPtr = 0;
    private Integer answer = 0;
    private final Map<Character, Integer> compareCase = new HashMap<>();
    private final Map<Character, Integer> target = new HashMap<>();

    public EveryAnagramFinder(String s, String t) {
        this.s = s;
        this.t = t;
    }

    public Integer findAllOf() {
        // #1: 아나그램을 비교할 수 있도록 Target(T 문자열)의 알파벳을 미리 세팅
        createTarget();

        // #2: S 문자열에서 T 문자열 바로 전까지 미리 넣어놓기
        readyForSliding();

        // #3: T의 마지막 글자부터 compareCase(S 부분문자열)을 바꿔가며 S의 끝 지점에 돌 때까지 아나그램인지 여부를 확인하기
        for(rightPtr = t.length()-1; rightPtr <s.length(); rightPtr++){
            // #3.1: comapreCase 갱신
            compareCase.put(s.charAt(rightPtr), compareCase.getOrDefault(s.charAt(rightPtr),0) + 1);

            // #3.2: 아나그램 여부 확인
            if(isEqualToTarget()){
                answer++;
            };

            // #3.3: leftPtr 위치의 문자를 compareCase에서 감소
            compareCase.put(s.charAt(leftPtr), compareCase.get(s.charAt(leftPtr))-1);

            // #3.4: 만약 한번도 나온 적이 없게 된다면 제거
            if(compareCase.get(s.charAt(leftPtr)) == 0){
                compareCase.remove(s.charAt(leftPtr));
            }

            // #3.5: leftPtr 밀어주기
            leftPtr++;
        }

        return answer;
    }

    private void readyForSliding() {
        for (int i = 0; i < t.length()-1; i++) {
            compareCase.put(s.charAt(i), compareCase.getOrDefault(s.charAt(i),0) + 1);
        }
    }

    private void createTarget() {
        for(Character character : t.toCharArray()){
            target.put(character, target.getOrDefault(character,0) + 1);
        }
    }

    private Boolean isEqualToTarget() {
        Boolean equalFlag = Boolean.TRUE;

        for (Map.Entry<Character, Integer> entry : compareCase.entrySet()) {
            if(!target.containsKey(entry.getKey())){
                equalFlag = Boolean.FALSE;
            }

            if(!(target.get(entry.getKey()) == entry.getValue())){
                equalFlag = Boolean.FALSE;
            }
        }

        return equalFlag;
    }
}
