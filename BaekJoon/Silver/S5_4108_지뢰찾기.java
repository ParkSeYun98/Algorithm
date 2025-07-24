package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_4108_지뢰찾기 {

    static int R, C;

    static int[] dr = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dc = {1, -1, 0, 0, 1, -1, -1, 1};

    static String[][] map, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(R==0 && C==0)
                return;

            map = new String[R][C];
            answer = new String[R][C];

            for(int i=0; i<R; i++) {
                String input = br.readLine();

                for(int j=0; j<input.length(); j++)
                    map[i][j] = String.valueOf(input.charAt(j));
            }

            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(map[i][j].equals("*")) {
                        answer[i][j] = map[i][j];
                        continue;
                    }

                    check(i, j);
                }
            }

            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++)
                    System.out.print(answer[i][j]);

                System.out.println();
            }
        }
    }

    static void check(int startR, int startC) {
        int cnt = 0;

        for(int d=0; d<8; d++) {
            int nextR = startR + dr[d];
            int nextC = startC + dc[d];

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(map[nextR][nextC].equals("*"))
                cnt++;
        }

        answer[startR][startC] = String.valueOf(cnt);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=R || c>=C;
    }
}
