package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_3187_양치기_꿍 {

    static int R, C, sheepCnt, wolfCnt;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static char[][] map;
    static boolean[][] visited;

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sheepCnt = 0;
        wolfCnt = 0;
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                map[i][j] = input.charAt(j);
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(!visited[i][j] && map[i][j] != '#')
                    BFS(new Point(i, j));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sheepCnt).append(" ").append(wolfCnt);

        System.out.println(sb);
    }

    static void BFS(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.r][start.c] = true;

        int wCnt = 0;
        int sCnt = 0;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(map[now.r][now.c] == 'k')
                sCnt++;
            else if(map[now.r][now.c] == 'v')
                wCnt++;

            for(int dir=0; dir<4; dir++) {
                int nextR = now.r + dr[dir];
                int nextC = now.c + dc[dir];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(wallCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
            }
        }

        if(sCnt > wCnt)
            sheepCnt += sCnt;
        else
            wolfCnt += wCnt;
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=R || c>=C;
    }

    static boolean wallCheck(int r, int c) {
        return map[r][c] == '#';
    }
}
