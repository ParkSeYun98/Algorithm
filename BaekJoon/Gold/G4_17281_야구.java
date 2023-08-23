package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_17281_야구 {

    private static int N;
    private static int score;
    private static int out;
    private static int max = Integer.MIN_VALUE;

    private static boolean[] visited;
    private static int[] order;
    private static boolean[] base;

    private static int[][] attackScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        attackScore = new int[N+1][10];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<9; j++) {
                attackScore[i+1][j+1] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[10];
        order = new int[10];
        base = new boolean[4];

        findOrder(1);

        System.out.println(max);
    }

    public static void findOrder(int depth) {
        if(depth == 10 && order[4] == 1) {

            simulation();

            max = Math.max(max, score);

            return;
        }

        for(int i=1; i<=9; i++) {
            if(!visited[i]) {
                order[depth] = i;
                visited[i] = true;
                findOrder(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void simulation() {
        out = 0;
        score = 0;

        int idx = 1;

        for(int i=0; i<N; i++) {

            while(true) {
                if(out == 3)
                    break;

                if(idx == 10)
                    idx = 1;

                attack(attackScore[i+1][order[idx]]);
                idx++;
            }

            Arrays.fill(base, false);
            out = 0;
        }
    }

    public static void attack(int hit) {
        if(hit == 0) {
            out++;
        }
        else if(hit == 1) {
            if(base[3]) {
                base[3] = false;
                score++;
            }

            if(base[2]) {
                base[2] = false;
                base[3] = true;
            }

            if(base[1]) {
                base[1] = false;
                base[2] = true;
            }

            base[1] = true;
        }
        else if(hit == 2) {
            if(base[3]) {
                score++;
                base[3] = false;
            }

            if(base[2]) {
                score++;
                base[2] = false;
            }

            if(base[1]) {
                base[1] = false;
                base[3] = true;
            }

            base[2] = true;
        }
        else if(hit == 3) {
            if(base[3]) {
                score++;
                base[3] = false;
            }

            if(base[2]) {
                score++;
                base[2] = false;
            }

            if(base[1]) {
                score++;
                base[1] = false;
            }

            base[3] = true;
        }
        else {
            if(base[3]) {
                base[3] = false;
                score++;
            }

            if(base[2]) {
                base[2] = false;
                score++;
            }

            if(base[1]) {
                base[1] = false;
                score++;
            }

            score++;
        }
    }
}
