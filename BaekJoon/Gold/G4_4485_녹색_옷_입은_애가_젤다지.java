package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_4485_녹색_옷_입은_애가_젤다지 {
    private static final int INF = Integer.MAX_VALUE;

    private static int N;

    private static final int[] dr = {0, 0, 1, -1};
    private static final int[] dc = {1, -1, 0, 0};

    private static int[][] distance;

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = 1;

        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N == 0)
                return;

            map = new int[N][N];
            distance = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<N; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            Dijkstra();

            System.out.println("Problem " + (tc++) + ": " + distance[N-1][N-1]);
        }
    }

    public static void Dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, map[0][0]));

        for(int i=0; i<N; i++)
            Arrays.fill(distance[i], INF);

        distance[0][0] = map[0][0];

        while(!pq.isEmpty()) {
            Point now = pq.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.row + dr[d];
                int nextC = now.col + dc[d];

                if(outofmapCheck(nextR, nextC))
                    continue;

                if(distance[nextR][nextC] > distance[now.row][now.col] + map[nextR][nextC]) {
                    distance[nextR][nextC] = distance[now.row][now.col] + map[nextR][nextC];
                    pq.offer(new Point(nextR, nextC, distance[nextR][nextC]));
                }
            }
        }
    }

    public static boolean outofmapCheck(int row, int col) {
        return row<0 || col<0 || row>=N || col>=N;
    }

    public static class Point implements Comparable<Point> {
        int row;
        int col;
        int cost;

        public Point(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
}
