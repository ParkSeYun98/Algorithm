package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class D4_1249_보급로 {
    private static final int INF = Integer.MAX_VALUE;

    private static int N;

    private static boolean[][] visited;
    private static int[][] distance;

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            for(int i=0; i<N; i++) {
                String input = br.readLine();

                for(int j=0; j<input.length(); j++)
                    map[i][j] = input.charAt(j) - '0';
            }

            Dijkstra();

            System.out.println("#" + tc + " " + distance[N-1][N-1]);
        }
    }

    public static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        visited = new boolean[N][N];
        distance = new int[N][N];

        for(int i=0; i<N; i++)
            Arrays.fill(distance[i], INF);

        distance[0][0] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.x == N-1 && now.y == N-1)
                break;

            if(visited[now.x][now.y])
                continue;

            visited[now.x][now.y] = true;

            for(int d=0; d<4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(visited[nextX][nextY])
                    continue;

                if(distance[nextX][nextY] >= distance[now.x][now.y] + map[nextX][nextY]) {
                    distance[nextX][nextY] = distance[now.x][now.y] + map[nextX][nextY];
                    pq.offer(new Node(nextX, nextY, distance[nextX][nextY]));
                }
            }
        }
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=N || y>=N;
    }

    public static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
