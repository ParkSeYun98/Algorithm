package SWEA.모의_SW_역량_테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 모의_SW_역량_테스트_2105_디저트_카페 {
    private static int N;
    private static int startx;
    private static int starty;
    private static int max;

    // 시계방향 : 우하, 좌하, 좌상, 우상
    private static int[] dx = {1, 1, -1, -1};
    private static int[] dy = {1, -1, -1, 1};

    private static int[][] map;

    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<N; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            max = -1;

            for(int i=0; i<N-2; i++) {
                for(int j=1; j<N-1; j++) {
                    startx = i;
                    starty = j;

                    list = new ArrayList<>();
                    list.add(map[i][j]);
                    DFS(i, j, 0);

                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    public static void DFS(int startX, int startY, int dir) {
        if(dir > 3)
            return;

        int nextX = startX + dx[dir];
        int nextY = startY + dy[dir];

        if(nextX == startx && nextY == starty && dir == 3) {
            max = Math.max(max, list.size());
            return;
        }

        if(outofmapCheck(nextX, nextY)) {
            return;
        }

        if(alreadyEatCheck(map[nextX][nextY])) {
            return;
        }

        list.add(map[nextX][nextY]);

        if(nextX == 0 || nextY == 0 || nextX == N-1 || nextY == N-1)
            DFS(nextX, nextY, dir+1);
        else {
            DFS(nextX, nextY, dir);
            DFS(nextX, nextY, dir + 1);
        }

        list.remove(list.size()-1);
    }

    public static boolean alreadyEatCheck(int dessert) {
        return list.contains(dessert);
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=N || y>=N;
    }
}
