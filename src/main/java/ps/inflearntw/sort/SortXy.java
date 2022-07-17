package ps.inflearntw.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortXy {

    static class Point implements Comparable<Point> {
        private int x;
        private int y;

        public Point(int x,int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x==o.x) {
                return this.y-o.y;
            } else {
                return this.x-o.x;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Point> points = new ArrayList<>();

        int pointCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < pointCnt; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            points.add(new Point(x,y));
        }
        Collections.sort(points);
        for (Point point : points) {
            System.out.println(point.x + " " + point.y);
        }

    }
}
