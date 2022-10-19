package ps.inflearntw.recursion;

public class Factorial {

    public int find(int hang) {
        if (hang == 1) {
            return 1;
        } else if (hang == 2) {
            return 1;
        } else {
            return find(hang - 2) + find(hang - 1);
        }
    }

}
