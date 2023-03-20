package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_3055_탈출 {
    private static int R;
    private static int C;
    private static Point startP;
    private static Point endP;
    private static int min = Integer.MAX_VALUE;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i=0; i<R; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++) {
                char temp = input.charAt(j);
                map[i][j] = temp;

                if(temp == 'S')
                    startP = new Point(i, j);
                else if(temp == 'D')
                    endP = new Point(i, j);
            }
        }

        BFS();

        if(min == Integer.MAX_VALUE)
            System.out.println("KAKTUS");
        else
            System.out.println(min);
    }

    public static void BFS() {
        Queue<Point> hedgehog = new LinkedList<>();
        Queue<Point> water = new LinkedList<>();

        hedgehog.offer(new Point(startP.x, startP.y, 0));

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == '*')
                    water.offer(new Point(i, j));
            }
        }

        while(!hedgehog.isEmpty()) {
            int watercnt = water.size();

            for(int i=0; i<watercnt; i++) {
                Point nowWater = water.poll();
                int nowWaterX = nowWater.x;
                int nowWaterY = nowWater.y;

                for(int d=0; d<4; d++) {
                    int nextWaterX = nowWaterX + dx[d];
                    int nextWaterY = nowWaterY + dy[d];

                    if(outofmapCheck(nextWaterX, nextWaterY))
                        continue;

                    if(emptyCheck(nextWaterX, nextWaterY)) {
                        map[nextWaterX][nextWaterY] = '*';
                        water.offer(new Point(nextWaterX, nextWaterY));
                    }
                }
            }

            int hedgehogcnt = hedgehog.size();

            for(int i=0; i<hedgehogcnt; i++) {
                Point nowhedgehog = hedgehog.poll();
                int nowhedgehogX = nowhedgehog.x;
                int nowhedgehogY = nowhedgehog.y;

                for(int d=0; d<4; d++) {
                    int nexthedgehogX = nowhedgehogX + dx[d];
                    int nexthedgehogY = nowhedgehogY + dy[d];

                    if(outofmapCheck(nexthedgehogX, nexthedgehogY))
                        continue;

                    if(houseCheck(nexthedgehogX, nexthedgehogY)) {
                        min = Math.min(min, nowhedgehog.t + 1);
                        return;
                    }

                    if(emptyCheck(nexthedgehogX, nexthedgehogY)) {
                        map[nexthedgehogX][nexthedgehogY] = 'S';
                        hedgehog.offer(new Point(nexthedgehogX, nexthedgehogY, nowhedgehog.t + 1));
                    }
                }
            }
        }
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=R || y>=C;
    }

    public static boolean houseCheck(int x, int y) {
        return x == endP.x && y == endP.y;
    }

    public static boolean emptyCheck(int x, int y) {
        return map[x][y] == '.';
    }

    public static class Point {
        int x;
        int y;
        int t;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}