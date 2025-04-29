package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_144987_주난의_난 {

    static int N, M, x1, y1, x2, y2;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static char[][] classroom;

    static class Node implements Comparable<Node> {
        int r;
        int c;
        int jumpCnt;

        public Node(int r, int c, int jumpCnt) {
            this.r = r;
            this.c = c;
            this.jumpCnt = jumpCnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.jumpCnt - o.jumpCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y1 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;

        classroom = new char[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                classroom[i][j] = input.charAt(j);
        }

        System.out.println(djikstra());
    }

    static int djikstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x1, y1, 0));

        boolean[][] visited = new boolean[N][M];
        visited[x1][y1] = true;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if((now.r == x2) && (now.c == y2))
                return now.jumpCnt;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                pq.add(new Node(nextR, nextC, (classroom[nextR][nextC] == '0' ? now.jumpCnt : now.jumpCnt+1)));
                visited[nextR][nextC] = true;
            }
        }

        return 0;
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }
}
