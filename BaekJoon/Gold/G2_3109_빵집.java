package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_3109_빵집 {

    static int R, C, cnt;

    static int[] dr = {-1, 0, 1};
    static int[] dc = {1, 1, 1};

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cnt = 0;
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++)
                map[i][j] = input.charAt(j);
        }

        for(int i=0; i<R; i++)
            DFS(i, 0);

        System.out.println(cnt);
    }

    static boolean DFS(int r, int c) {
        for(int d=0; d<3; d++) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(buildingCheck(nextR, nextC))
                continue;

            if(nextC == C-1) {
                cnt++;
                return true;
            }

            map[nextR][nextC] = 'x';

            if(DFS(nextR, nextC))
                return true;
        }

        return false;
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=R || c>=C;
    }

    static boolean buildingCheck(int r, int c) {
        return map[r][c] == 'x';
    }
}
