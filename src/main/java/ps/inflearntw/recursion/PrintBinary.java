package ps.inflearntw.recursion;

public class PrintBinary {

    private int number;
    private StringBuilder result = new StringBuilder();

    public PrintBinary(int number) {
        this.number = number;
    }

    /*
     숫자를 2로 나누고 나머지를 문자열에 저장
     나눈 결과값은 새로운 숫자로 할당
     만약 결과값이 0이 된다면 종료
    */
    public String printToBinary() {
        if (isDividable()) {
            appendRemainToResult();
            updateNumber();
            printToBinary();
        } else {
            appendLastQuotientToResult();
            result.reverse();
        }

        return result.toString();
    }

    private void appendLastQuotientToResult(){
        result.append(number);
    }

    private void appendRemainToResult() {
        result.append(number % 2);
    }

    private void updateNumber() {
        this.number = number / 2;
    }

    private boolean isDividable() {
        return number / 2 > 0;
    }
}
