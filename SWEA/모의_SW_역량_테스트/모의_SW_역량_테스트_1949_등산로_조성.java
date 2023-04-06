package SWEA.모의_SW_역량_테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 모의_SW_역량_테스트_1949_등산로_조성 {
    static int N;
    static int K;
    static int maxDistance;

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int max = -1;
            maxDistance = Integer.MIN_VALUE;
            map = new int[N][N];
            List<Point> topList = new ArrayList<>();

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if(max < map[i][j]) {
                        max = map[i][j];

                        topList = new ArrayList<>();
                        topList.add(new Point(i, j, 1, 1));
                    }
                    else if(max == map[i][j])
                        topList.add(new Point(i, j, 1, 1));
                }
            }

            for(int i=0; i<topList.size();i++) {
                visited = new boolean[N][N];
                visited[topList.get(i).r][topList.get(i).c] = true;
                DFS(topList.get(i));
                visited[topList.get(i).r][topList.get(i).c] = false;
            }

            System.out.println("#" + tc + " " + maxDistance);
        }
    }

    static void DFS(Point now) {
        maxDistance = Math.max(maxDistance, now.distance);

        for(int d=0; d<4; d++) {
            int nextR = now.r + dr[d];
            int nextC = now.c + dc[d];

            if(outofmapCheck(nextR, nextC))
                continue;

            if(visited[nextR][nextC])
                continue;

            if(map[now.r][now.c] > map[nextR][nextC]) {
                visited[nextR][nextC] = true;
                DFS(new Point(nextR, nextC, now.chance, now.distance+1));
                visited[nextR][nextC] = false;
            }
            else {
                if(now.chance == 1) {
                    if(map[now.r][now.c] > map[nextR][nextC] - K) {
                        int temp = map[nextR][nextC];

                        map[nextR][nextC] = map[now.r][now.c]-1;
                        visited[nextR][nextC] = true;
                        DFS(new Point(nextR, nextC, now.chance-1, now.distance+1));
                        visited[nextR][nextC] = false;
                        map[nextR][nextC] = temp;
                    }
                }
            }
        }
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    static class Point {
        int r;
        int c;
        int chance;
        int distance;

        public Point(int r, int c, int chance, int distance) {
            this.r = r;
            this.c = c;
            this.chance = chance;
            this.distance = distance;
        }
    }
}
