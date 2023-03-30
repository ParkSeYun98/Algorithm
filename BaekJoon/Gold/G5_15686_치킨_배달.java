package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G5_15686_치킨_배달 {
    private static int N;
    private static int M;
    private static int min;

    private static int[] surviveChicken;

    private static int[][] city;

    private static List<Point> chickenList;
    private static List<Point> houseList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chickenList = new ArrayList<>();
        houseList = new ArrayList<>();
        surviveChicken = new int[M];
        city = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if(city[i][j] == 1)
                    houseList.add(new Point(i, j));
                else if(city[i][j] == 2)
                    chickenList.add(new Point(i, j));
            }
        }

        min = Integer.MAX_VALUE;

        Combination(0, 0);

        System.out.println(min);
    }

    public static void Combination(int depth, int idx) {
        if(depth == M) {
            min = Math.min(min, getchickenDistance());
            return;
        }

        for(int i=idx; i<chickenList.size(); i++) {
            surviveChicken[depth] = i;
            Combination(depth+1, i+1);
        }
    }

    public static int getchickenDistance() {
        int chickenDistance = 0;
        Point[] survivechickenInfo = new Point[surviveChicken.length];

        for(int i=0; i<surviveChicken.length; i++) {
            Point p = chickenList.get(surviveChicken[i]);
            survivechickenInfo[i] = p;
        }


        for(int i=0; i<houseList.size(); i++) {
            int minDistance = Integer.MAX_VALUE;

            for(int j=0; j<survivechickenInfo.length; j++) {
                 int distance = Math.abs(houseList.get(i).x - survivechickenInfo[j].x) + Math.abs(houseList.get(i).y - survivechickenInfo[j].y);
                 minDistance = Math.min(minDistance, distance);
            }

            chickenDistance += minDistance;
        }

        return chickenDistance;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
