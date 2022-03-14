package ps;

// https://programmers.co.kr/learn/courses/30/lessons/77884
public class NumOfYaksuAndPlus {

	static int solution(int left, int right) {

		int answer = 0;

		for (int i = left; i <= right; i++) {
			int yak = 2;

			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					yak++;
				}
			}

			if (yak % 2 == 0) {
				answer += i;
			} else {
				answer -= i;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int left = 13;
		int right = 17;

		System.out.println(solution(left, right));
	}
}
