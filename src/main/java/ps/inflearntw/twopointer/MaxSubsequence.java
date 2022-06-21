package ps.inflearntw.twopointer;

public class MaxSubsequence {
    private final int[] sequence;
    private final int availableConvertCnt;

    private int startPointer;
    private int endPointer;
    private int howManyZero;

    public MaxSubsequence(int[] sequence, int availableConvertCnt) {
        this.sequence = sequence;
        this.availableConvertCnt = availableConvertCnt;
    }

    public int findMaxLengthOfSequence() {
        int answer = 0;

        // 1,1,0,0,1,1,0,1,1,0,1,1,0,1
        for (int endPointer= 0; endPointer < sequence.length; endPointer++) {
            // 0을 만나면 K의 횟수를 깎아라
            if(sequence[endPointer] == 0){
                howManyZero++;
                System.out.println("find!");
            }

            // k보다 더 많이 0을 찾은 순간
            while(howManyZero > availableConvertCnt){
                if(sequence[startPointer] == 0){
                    howManyZero--;
                }
                startPointer++;
            }

            answer = Math.max(answer, endPointer - startPointer + 1);
        }

        return answer;
    }
}
