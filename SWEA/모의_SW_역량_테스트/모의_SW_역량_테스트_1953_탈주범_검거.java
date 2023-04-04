package SWEA.모의_SW_역량_테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 모의_SW_역량_테스트_1953_탈주범_검거 {
    private static int N;
    private static int M;
    private static int R;
    private static int C;
    private static int L;

    // 상 우 하 좌
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<M; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N][M];

            BFS();

            System.out.println("#" + tc + " " + Print());
        }
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(R, C));

        visited[R][C] = true;
        int time = 1;

        while(true) {
            if(time >= L)
                return;

            List<Point> tempList = new ArrayList<>();

            while(!queue.isEmpty()) {
                Point now = queue.poll();

                List<Integer> directionList = getNextDirection(now.r, now.c);

                for(int d=0; d<directionList.size(); d++) {
                    int nextR = now.r + dr[directionList.get(d)];
                    int nextC = now.c + dc[directionList.get(d)];

                    if(outofmapCheck(nextR, nextC))
                        continue;

                    if(!pipecheck(nextR, nextC))
                        continue;

                    if(!checknextDirection(nextR, nextC, directionList.get(d)))
                        continue;

                    if(visited[nextR][nextC])
                        continue;

                    tempList.add(new Point(nextR, nextC));
                    visited[nextR][nextC] = true;
                }
            }

            for (Point point : tempList)
                queue.offer(point);

            time++;
        }
    }

    public static List<Integer> getNextDirection(int nowR, int nowC) {
        List<Integer> dirList = new ArrayList<>();

        if(map[nowR][nowC] == 1) {
            for(int d=0; d<4; d++)
                dirList.add(d);
        }
        else if(map[nowR][nowC] == 2) {
            dirList.add(0);
            dirList.add(2);
        }
        else if(map[nowR][nowC] == 3) {
            dirList.add(1);
            dirList.add(3);
        }
        else if(map[nowR][nowC] == 4) {
            dirList.add(0);
            dirList.add(1);
        }
        else if(map[nowR][nowC] == 5) {
            dirList.add(1);
            dirList.add(2);
        }
        else if(map[nowR][nowC] == 6) {
            dirList.add(2);
            dirList.add(3);
        }
        else if(map[nowR][nowC] == 7) {
            dirList.add(3);
            dirList.add(0);
        }

        return dirList;
    }

    public static int Print() {
        int cnt = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j])
                    cnt++;
            }
        }

        return cnt;
    }

    public static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }

    public static boolean pipecheck(int r, int c) {
        return map[r][c] != 0;
    }

    public static boolean checknextDirection(int r, int c, int d) {
        int temp = map[r][c];

        if(d == 0) {
            if(temp == 3 || temp == 4 || temp == 7)
                return false;
        }
        else if(d == 1) {
            if(temp == 2 || temp == 4 || temp == 5)
                return false;
        }
        else if(d == 2) {
            if(temp == 3 || temp == 5 || temp == 6)
                return false;
        }
        else {
            if(temp == 2 || temp == 6 || temp == 7)
                return false;
        }

        return true;
    }

    public static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
