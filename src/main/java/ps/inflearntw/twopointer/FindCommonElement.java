package ps.inflearntw.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonElement {
    private List<Integer> answer;
    private int[] first;
    private int[] second;
    private int pointer1;
    private int pointer2;

    public FindCommonElement(int[] first, int[] second) {
        this.first = first;
        this.second = second;
        this.answer = new ArrayList<>();
        sort();
    }

    private void sort() {
        Arrays.sort(first);
        Arrays.sort(second);
    }

    public static FindCommonElement of(int[] first, int[] second) {
        return new FindCommonElement(first, second);
    }

    public int[] findCommonElement() {
        // 각 포인터가 배열의 끝에 다다르기 전까지 공통 요소 찾기
        addCommonElementUntilAnyPointerIsSmallerThanArrayLength();

        return convertListToArray();
    }

    private void addCommonElementUntilAnyPointerIsSmallerThanArrayLength() {
        while (isBothPointerLessThanArrayLength()) {
            // 둘이 같은지를 확인한다. 만약 같다면 정답에 넣기
            if (isSameWith(first[pointer1], second[pointer2])) {
                addCommonElement(first);
                pointer1++; pointer2++;
            } else if (first[pointer1] < second[pointer2]) {
                pointer1++;
            } else {
                pointer2++;
            }
        }
    }

    private boolean isBothPointerLessThanArrayLength() {
        return isPointerLessThan(pointer1, first) && isPointerLessThan(pointer2, second);
    }

    private boolean isSameWith(int first, int second) {
        return first == second;
    }

    private void addCommonElement(int[] first) {
        answer.add(first[pointer1]);
    }

    private boolean isPointerLessThan(int pointer1, int[] first) {
        return pointer1 < first.length;
    }

    private int[] convertListToArray() {
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
