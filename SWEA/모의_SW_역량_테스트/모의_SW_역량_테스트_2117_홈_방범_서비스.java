package SWEA.모의_SW_역량_테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 모의_SW_역량_테스트_2117_홈_방범_서비스 {
    static int N;
    static int M;
    static int houseCnt;
    static int result;
    static int max;

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    static int[][] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            city = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<N; j++)
                    city[i][j] = Integer.parseInt(st.nextToken());
            }

            result = 0;
            max = Integer.MIN_VALUE;

            for(int k=1; k<=N+1; k++) {
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        houseCnt = 0;

                        BFS(i, j, k);

                        int nowGain = getGain(k);

                        if(nowGain < 0)
                            continue;

                        if(max < houseCnt)
                            max = houseCnt;
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    static void BFS(int r, int c, int K) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c));

        boolean[][] visited = new boolean[N][N];
        visited[r][c] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(city[now.r][now.c] == 1)
                houseCnt++;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outofmapCheck(nextR, nextC))
                    continue;

                if(!rangeCheck(nextR, nextC, r, c, K))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
            }
        }
    }

    static int getGain(int K) {
        int service = K*K + (K-1)*(K-1);
        int earn = houseCnt * M;

        return earn - service;
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    static boolean rangeCheck(int nextR, int nextC, int r, int c, int K) {
        return getDistance(nextR, nextC, r, c) <= (K - 1);
    }

    static int getDistance(int nextR, int nextC, int r, int c) {
        return Math.abs(nextR - r) + Math.abs(nextC - c);
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
