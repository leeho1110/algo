package ps.inflearntw;

public class CompressionString {

    private final String text;
    private int index;
    private int repeatCount = 1;
    private StringBuilder answer = new StringBuilder();

    public CompressionString(String text) {
        this.text = text;
    }

    public String compression() {
        // check difference from next index until last index
        for (int i = 0; i < text.length() - 1; i++) {
            compareToNextIndex();
            moveIndex();
        }

        // last Index process
        appendAnswer();

        return answer.toString();
    }

    private void compareToNextIndex() {
        if (isEqualToNext()) {
            addRepeatCount();
        } else {
            appendAnswer();
            initializeRepeatCount();
        }
    }

    public Boolean isEqualToNext() {
        if (index < text.length() - 1) {
            return text.charAt(index) == text.charAt(index + 1);
        } else {
            return false;
        }

    }

    public void addRepeatCount() {
        this.repeatCount++;
    }

    public void appendAnswer() {
        String count = repeatCount > 1 ? String.valueOf(repeatCount) : "";
        this.answer.append(text.charAt(index) + count);
    }

    public void initializeRepeatCount() {
        this.repeatCount = 1;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    private void moveIndex() {
        this.index++;
    }

    public String getAnswer() {
        return this.answer.toString();
    }

}
