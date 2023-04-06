package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_16234_인구_이동 {
    static int N;
    static int L;
    static int R;
    static int day = 0;
    static boolean flag = false;

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    static int[][] land;

    static boolean[][] visited;

    static List<Point> unionList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        land = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++)
                land[i][j] = Integer.parseInt(st.nextToken());
        }

        populationMove();

        System.out.println(day);
    }

    static void populationMove() {
        while (true) {
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        BFS(i, j);
                        Move();
                    }
                }
            }

            if(flag) {
                day++;
                flag = false;
            }
            else
                break;
        }
    }

    static void BFS(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c));

        visited[r][c] = true;

        unionList = new ArrayList<>();
        unionList.add(new Point(r, c));

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outofmapCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                if(!populationDiffCheck(now.r, now.c, nextR, nextC))
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
                unionList.add(new Point(nextR, nextC));
                flag = true;
            }
        }
    }

    static void Move() {
        int sum = 0;

        for (Point union : unionList)
            sum += land[union.r][union.c];

        int nextPopulation = sum / unionList.size();

        for (Point union : unionList)
            land[union.r][union.c] = nextPopulation;
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    static boolean populationDiffCheck(int nowR, int nowC, int nextR, int nextC) {
        int diff = getDifference(nowR, nowC, nextR, nextC);

        return diff >= L && diff <= R;
    }

    static int getDifference(int nowR, int nowC, int nextR, int nextC) {
        return Math.abs(land[nowR][nowC] - land[nextR][nextC]);
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
