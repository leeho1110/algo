package ps;

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
			this.usedHand = hand;
		}

		public void pressButtons(int[] numbers) {
			for(int number : numbers){
				press(number);
			}
		}

		private void press(int number) {
			pressHistory += selectHand(number);
		}

		private String selectHand(int number){
			String hand = "";

			if(number == 1 || number == 4 || number == 7) {
				hand = "L";
			};

			if(number == 3 || number == 6 || number == 9){
				hand = "R";
			};

			if(number == 2 || number == 5 || number == 8 || number == 0) {
				hand = choice(number);
			}

			changeHandLocation(getHandLocation(number), hand.equals("R") ? "right" : "left");

			return hand;
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

		private String choice(int number) {
			String hand = "";
			int[] numberLocation = getHandLocation(number);

			int leftHandCost = Math.abs(numberLocation[0]-leftHandLocation[0]) + Math.abs(numberLocation[1]-leftHandLocation[1]);
			int rightHandCost = Math.abs(numberLocation[0]-rightHandLocation[0]) + Math.abs(numberLocation[1]-rightHandLocation[1]);

			if(leftHandCost < rightHandCost){
				hand = "L";
			} else if(rightHandCost < leftHandCost) {
				hand = "R";
			} else if(leftHandCost == rightHandCost){
				if(usedHand.equals("right")){
					hand = "R";
				} else {
					hand = "L";
				}
			}

			changeHandLocation(numberLocation, hand.equals("R") ? "right" : "left");

			return hand;
		}

		private void changeHandLocation(int[] location, String hand){
			if(hand.equals("right")){
				this.rightHandLocation = location;
				return;
			}
			if(hand.equals("left")){
				this.leftHandLocation = location;
				return;
			}
		}

		public String getPressHistory() {
			return pressHistory;
		}
	}
}
