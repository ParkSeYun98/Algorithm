package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1261_알고스팟 {
    static final int INF = Integer.MAX_VALUE;

    static int N;
    static int M;

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    static boolean[][] visited;
    static int[][] distance;

    static int[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        maze = new int[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<M; j++)
                maze[i][j] = input.charAt(j) - '0';
        }

        dijkstra();

        if(distance[N-1][M-1] == INF)
            System.out.println(0);
        else
            System.out.println(distance[N-1][M-1]);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, maze[0][0]));

        visited = new boolean[N][M];
        distance = new int[N][M];

        for(int i=0; i<N; i++)
            Arrays.fill(distance[i], INF);

        distance[0][0] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.r == N-1 && now.c == M-1)
                break;

            if(visited[now.r][now.c])
                continue;

            visited[now.r][now.c] = true;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outofmapCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                if(distance[nextR][nextC] >= distance[now.r][now.c] + maze[nextR][nextC]) {
                    distance[nextR][nextC] = distance[now.r][now.c] + maze[nextR][nextC];
                    pq.offer(new Node(nextR, nextC, distance[nextR][nextC]));
                }
            }
        }
    }

    static boolean outofmapCheck(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= M;
    }

    static class Node implements Comparable<Node> {
        int r;
        int c;
        int w;

        public Node(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
