package ps;

public class AppendAndDelete {
    public static final String YES = "Yes";
    public static final String NO = "No";
    private final String s;
    private final String t;
    private final int limit;
    private int count;
    private int turnPoint;

    public AppendAndDelete(String s, String t, int k) {
        this.s = s;
        this.t = t;
        this.limit = k;
    }

    public String check() {
        if (isSameText()) {
            count = 1;
            return isLessOrEqualsThanLimit() ? YES : NO;
        }

        turnPoint = Math.min(s.length(), t.length());
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            // 만약 달라졌다면 해당 지점부터 연산이 필요하니까 저장
            if (s.toCharArray()[i] != t.toCharArray()[i]) {
                turnPoint = i;
            }
        }

        calculateCount();
        return isLessOrEqualsThanLimit() ? YES : NO;
    }

    private boolean isSameText() {
        return s.equals(t);
    }

    private void calculateCount() {
        count += s.length() - turnPoint + t.length() - turnPoint;
    }

    private boolean isLessOrEqualsThanLimit() {
        return count <= limit;
    }
}
