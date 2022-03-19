package ps.programmers;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/67256
public class PressKeypad {

	private static String RIGHT_HAND = "R";
	private static String LEFT_HAND = "L";

	public String solution(int[] numbers, String hand) {
		Finger finger = new Finger(hand);
		finger.pressButtons(numbers);

		return finger.getPressHistory();
	}

	class Finger {

		private int[] leftHandLocation = {3,0};
		private int[] rightHandLocation = {3,2};

		private String usedHand;
		private String pressHistory = "";

		public Finger(String hand) {
			this.usedHand = hand.equals("right") ? RIGHT_HAND : LEFT_HAND;
		}

		public void pressButtons(int[] numbers) {
			Arrays.stream(numbers).forEach(this::press);
		}

		private void press(int number) {
			String hand = selectHand(number);
			changeHandLocation(getHandLocation(number), hand);
			addPressHistory(hand);
		}

		private String selectHand(int number){
			String hand = "";

			if(number == 1 || number == 4 || number == 7) { hand = LEFT_HAND; };
			if(number == 3 || number == 6 || number == 9){ hand = RIGHT_HAND; };
			if(number == 2 || number == 5 || number == 8 || number == 0) { hand = choice(number); }

			return hand;
		}

		protected String choice(int number) {
			String hand = "";

			int[] numberLocation = getHandLocation(number);

			int leftHandCost = getDistanceCost(numberLocation, leftHandLocation);
			int rightHandCost = getDistanceCost(numberLocation, rightHandLocation);

			if(leftHandCost < rightHandCost){
				hand = LEFT_HAND;
			} else if(rightHandCost < leftHandCost) {
				hand = RIGHT_HAND;
			} else {
				hand = usedHand;
			}

			return hand;
		}

		private int getDistanceCost(int[] numberLocation, int[] handLocation) {
			return Math.abs(numberLocation[0] - handLocation[0]) + Math.abs(numberLocation[1] - handLocation[1]);
		}

		private int[] getHandLocation(int number) {
			if(number == 1){return new int[]{0,0};}
			if(number == 2){return new int[]{0,1};}
			if(number == 3){return new int[]{0,2};}
			if(number == 4){return new int[]{1,0};}
			if(number == 5){return new int[]{1,1};}
			if(number == 6){return new int[]{1,2};}
			if(number == 7){return new int[]{2,0};}
			if(number == 8){return new int[]{2,1};}
			if(number == 9){return new int[]{2,2};}
			if(number == 0){return new int[]{3,1};}

			return new int[]{0,0};
		}

		private void changeHandLocation(int[] location, String hand){
			if(hand.equals(RIGHT_HAND)){
				this.rightHandLocation = location;
			}
			if(hand.equals(LEFT_HAND)){
				this.leftHandLocation = location;
			}
		}

		public String getPressHistory() {
			return pressHistory;
		}

		private void addPressHistory(String hand) {
			pressHistory += hand;
		}
	}
}
