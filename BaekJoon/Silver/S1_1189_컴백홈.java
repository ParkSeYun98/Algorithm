package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1189_컴백홈 {

    static int R, C, K, cnt;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cnt = 0;
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String temp = br.readLine();

            for(int j=0; j<temp.length(); j++)
                map[i][j] = temp.charAt(j);
        }

        visited[R-1][0] = true;
        DFS(1, R-1, 0);

        System.out.println(cnt);
    }

    static void DFS(int depth, int r, int c) {
        if(r==0 && c==C-1) {
            if(depth == K)
                cnt++;

            return;
        }

        for(int d=0; d<4; d++) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(TCheck(nextR, nextC))
                continue;

            if(visited[nextR][nextC])
                continue;

            visited[nextR][nextC] = true;
            DFS(depth+1, nextR, nextC);
            visited[nextR][nextC] = false;
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=R || c>=C;
    }

    static boolean TCheck(int r, int c) {
        return map[r][c] == 'T';
    }
}
