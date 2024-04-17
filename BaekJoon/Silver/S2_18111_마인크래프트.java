package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_18111_마인크래프트 {

    static int N, M, B, min, max, ansT, ansH;

    static int[][] soil;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        ansT = Integer.MAX_VALUE;
        ansH = Integer.MIN_VALUE;
        soil = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++) {
                int input = Integer.parseInt(st.nextToken());

                soil[i][j] = input;
                max = Math.max(max, input);
                min = Math.min(min, input);
            }
        }

        for(int i=min; i<=max; i++) {
            int t = 0;
            int inventory = B;

            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    int diff = soil[j][k] - i;

                    if(diff > 0) {
                        t += 2 * Math.abs(diff);
                        inventory += Math.abs(diff);
                    }
                    else if(diff < 0) {
                        t += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            if(inventory >= 0) {
                if(t <= ansT) {
                    ansT = t;
                    ansH = i;
                }
            }
        }

        System.out.println(ansT + " " + ansH);
    }
}
