package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_1987_알파벳_2번째 {

    private static int R;
    private static int C;
    private static int max = 0;

    private static Horse firstLocation;

    private static int dr[] = {0, 0, 1, -1};
    private static int dc[] = {1, -1, 0, 0};

    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for(int i=0; i<R; i++) {
            String temp = br.readLine();

            for(int j=0; j<temp.length(); j++)
                board[i][j] = temp.charAt(j);
        }

        List<Character> list = new ArrayList<>();
        list.add(board[0][0]);

        firstLocation = new Horse(0, 0, list);

        Pass(firstLocation);

        System.out.println(max);
    }

    public static void Pass(Horse location) {
        for(int d=0; d<4; d++) {
            int nextR = location.r + dr[d];
            int nextC = location.c + dc[d];
            List<Character> list = location.trace;

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(location.trace.contains(board[nextR][nextC]))
                continue;

            list.add(board[nextR][nextC]);
            Pass(new Horse(nextR, nextC, list));
            list.remove(list.size()-1);
        }

        max = Math.max(max, location.trace.size());
    }

    public static boolean outOfMapCheck(int r, int c) {
        return r < 0 || c < 0 || r >= R || c >= C;
    }

    public static class Horse {
        int r;
        int c;
        List<Character> trace;

        public Horse(int r, int c, List<Character> trace) {
            this.r = r;
            this.c = c;
            this.trace = trace;
        }
    }
}
