package ps;

public class RecommendNewId {

    // Goal: 전달되는 numbers를 누른 손가락을 리턴하라

    // 키패드를 누르는 함수
    // 1,4,7 이 들어왔을 때에는 왼손으로 누르는 함수
    // 3,6,9 가 들어왔을 때에는 오른손으로 누르는 함수
    // 2,5,8,0 이 들어왔을 때에는 finger의 마지막 위치에 따라 누르는 손가락이 변경
    
    /*
    1(0,0) 2(0,1) 3(0,2)
    4(1,0) 5(1,1) 6(1,2)
    7(2,0) 8(2,1) 9(2,2)
    *(3,0) 0(3,1) #(3,2)
    */

    public String solution(int[] numbers, String hand) {
        Finger finger = new Finger(hand);
        finger.pressButtons(numbers);

        return finger.getPressHistory();
    }

    private static class Finger {

        private int[] leftHandLocation = {3,0};
        private int[] rightHandLocation = {3,2};

        private String usedHand;
        private String pressHistory;

        public Finger(String hand) {
            this.usedHand = hand;
        }

        public void pressButtons(int[] numbers) {
            for(int number : numbers){
                press(number);
            }
        }

        private void press(int number) {
            pressHistory += selecteHand(number);
        }

        private String selecteHand(int number){
            String hand = "";
            if(number == 1 || number == 4 || number == 7){
                leftHandLocation = getHandLocation(number);
                hand = "L";
            };

            if(number == 3 || number == 6 || number == 9){
                rightHandLocation = getHandLocation(number);
                hand = "R";
            };

            if(number == 2 || number == 5 || number == 8 || number == 0){
                hand = choice(number);
            }

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
            if(number == 0){return new int[]{3,2};}

            return new int[]{0,0};
        }

        private String choice(int number) {
            int[] numberLocation = getHandLocation(number);

            int leftEnergy = Math.abs(numberLocation[0]-leftHandLocation[0]) + Math.abs(numberLocation[1]-leftHandLocation[1]);
            int rightEnergy = Math.abs(numberLocation[0]-rightHandLocation[0]) + Math.abs(numberLocation[1]-rightHandLocation[1]);

            if(leftEnergy == rightEnergy){
                return usedHand.equals("right") ? "R" : "L";
            } else {
                return leftEnergy > rightEnergy ? "L" : "R";
            }
        }

        public String getPressHistory() {
            return pressHistory;
        }
    }
}