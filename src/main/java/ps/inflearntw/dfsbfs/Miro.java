package ps.inflearntw.dfsbfs;

public class Miro {

    /**
            * {0, 0, 0, 0, 0, 0, 0},
            * {0, 1, 1, 1, 1, 1, 0},
            * {0, 0, 0, 1, 0, 0, 0},
            * {1, 1, 0, 1, 0, 1, 1},
            * {1, 1, 0, 0, 0, 0, 1},
            * {1, 1, 0, 1, 1, 0, 0},
            * {1, 0, 0, 0, 0, 0, 0}
     * <p>
     * 1,1부터 돌면서 12시방향, 3시방향, 6시방향, 9시방향으로 차례로 전진한다.
     * 만약 해당 자리가 배열에 속하지 않거나, 막혀있는 경우 return(다음 방향으로)
            */
    private int answer;
    private int[][] miro;

    private final int[] nextX = {-1, 0, 1, 0};
    private final int[] nextY = {0, 1, 0, -1};


    public int findCase(final int[][] miro) {
        this.miro = miro;
        // 시작하는 곳은 이미 밟은 곳이니까 1로 변경해줘야함
        this.miro[0][0] = 1;

        searching(0, 0);
        return answer;
    }

    private void searching(int x, int y) {
        // 만약 도착했다면
        if (x == 6 && y == 6) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                if (isSearchable(x, y, i)) {
                    miro[x + this.nextX[i]][y + this.nextY[i]] = 1;
                    searching(x + this.nextX[i], y + this.nextY[i]);
                    miro[x + this.nextX[i]][y + this.nextY[i]] = 0;
                }
            }
        }
    }

    private boolean isSearchable(int x, int y, int i) {
        return x + nextX[i] >= 0
            && y + nextY[i] >= 0
            && x + nextX[i] < miro[0].length
            && y + nextY[i] < miro.length
            && miro[x + nextX[i]][y + nextY[i]] != 1;
    }
}
