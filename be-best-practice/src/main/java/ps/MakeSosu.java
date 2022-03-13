package ps;

// https://programmers.co.kr/learn/courses/30/lessons/12977
public class MakeSosu {

	private static int answer = 0;

	static int solution(int[] nums) {

		// i까지의 인덱스를 더한다

		for (int idx1 = 0; idx1 < nums.length; idx1++) {
			for (int idx2 = idx1 + 1; idx2 < nums.length; idx2++) {
				for (int idx3 = idx2 + 1; idx3 < nums.length; idx3++) {
					int sum = nums[idx1] + nums[idx2] + nums[idx3];
					checkSosu(sum);
				}
			}
		}

		return answer;
	}

	private static void checkSosu(int sum) {
		int end = (int)Math.sqrt(sum);
		boolean flag = true;

		for (int i = 2; i <= end; i++) {
			if (sum % i == 0) {
				flag = false;
			}
		}

		if (flag) {
			answer++;
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};

		// i만큼을 먼저 더하고 뒤에 하나씩 더하면 된다.

		int answer = solution(nums);
		System.out.println(answer);
	}
}
