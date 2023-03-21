package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_1987_알파벳 {
    private static int R;
    private static int C;
    private static int max = Integer.MIN_VALUE;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for(int i=0; i<R; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                board[i][j] = input.charAt(j);
        }

        List<Character> list = new ArrayList<>();
        list.add(board[0][0]);

        DFS(0, 0, 1, list);

        System.out.println(max);
    }

    public static void DFS(int startX, int startY, int depth, List<Character> list) {
        for(int d=0; d<4; d++) {
            max = Math.max(max, depth);

            int nextX = startX + dx[d];
            int nextY = startY + dy[d];


            if(outofmapCheck(nextX, nextY))
                continue;

            if(list.contains(board[nextX][nextY]))
                continue;

            list.add(board[nextX][nextY]);
            DFS(nextX, nextY, depth+1, list);
            list.remove(list.size()-1);
        }
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=R || y>=C;
    }
}