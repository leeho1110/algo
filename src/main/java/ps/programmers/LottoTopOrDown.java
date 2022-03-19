package ps.programmers;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/77484
public class LottoTopOrDown {

		private int[] winNums = {};
		private int correctCnt;
		private int zerroCnt;

		public int[] solution(int[] lottos, int[] win_nums) {
			winNums = win_nums;

			// 최고 순위, 최저 순위 알아보기
			for(int lotto : lottos){
				checkZero(lotto);
				checkCorrect(lotto);
			}

			int maxRank = correctCnt + zerroCnt;
			int minRank = correctCnt;

			int[] answer = {Math.min( 7- maxRank, 6), Math.min(7-minRank,6)};
			return answer;
		}

		private void checkCorrect(int number){
			if(isCorrect(number)){
				correctCnt++;
			}
		}

		private void checkZero(int number){
			if(number == 0){
				zerroCnt++;
			}
		}

		private boolean isCorrect(int number) {
			return Arrays.stream(winNums).anyMatch(winNum -> winNum == number);
		}
};
