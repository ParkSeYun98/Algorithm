package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_1941_소문난_칠공주 {
    static int result = 0;

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    static Point[] num;
    static int[] comb;
    static boolean[] visited;

    static char[][] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0;
        comb = new int[7];
        num = new Point[25];
        party = new char[5][5];

        for(int i=0; i<5; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++) {
                party[i][j] = input.charAt(j);
                num[idx++] = new Point(i, j);
            }
        }

        Combination(0, 0);

        System.out.println(result);
    }

    static void Combination(int depth, int idx) {
        if(depth == 7) {
            BFS();

            return;
        }

        for(int i=idx; i<25; i++) {
            comb[depth] = i;
            Combination(depth+1, i+1);
        }
    }

    static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(comb[0]);

        visited = new boolean[comb.length];
        visited[0] = true;

        int cnt = 1;
        int sCnt = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(party[num[now].r][num[now].c] == 'S')
                sCnt++;

            for(int d=0; d<4; d++) {
                int nextR = num[now].r + dr[d];
                int nextC = num[now].c + dc[d];

                for(int i=1; i<7; i++) {
                    if(visited[i])
                        continue;

                    if(nextR == num[comb[i]].r && nextC == num[comb[i]].c) {
                        queue.offer(comb[i]);
                        visited[i] = true;
                        cnt++;
                    }
                }
            }
        }

        if(cnt == 7 && sCnt >= 4)
            result++;
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=5 || c>=5;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
