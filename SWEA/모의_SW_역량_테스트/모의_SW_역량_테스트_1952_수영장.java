package SWEA.모의_SW_역량_테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의_SW_역량_테스트_1952_수영장 {
    private static int min;

    private static int[] charge;
    private static int[] swimmingPool;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            charge = new int[4];
            swimmingPool = new int[12];

            for(int i=0; i<4; i++)
                charge[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<12; i++)
                swimmingPool[i] = Integer.parseInt(st.nextToken());

            min = Integer.MAX_VALUE;

            getPlan(0, 0);

            System.out.println("#" + tc + " " + min);
        }
    }

    public static void getPlan(int depth, int partSum) {
        if(depth == 12) {
            min = Math.min(min, partSum);
            return;
        }

        for(int i=0; i<4; i++) {
            if(i == 0) {
                getPlan(depth + 1, partSum + swimmingPool[depth] * charge[i]);
            }
            else if(i == 1) {
                getPlan(depth + 1, partSum + charge[i]);
            }
            else if(i == 2) {
                if(depth <= 9)
                    getPlan(depth+3, partSum + charge[i]);
            }
            else {
                if(depth == 0) {
                    min = Math.min(min, charge[i]);
                    return;
                }
            }
        }
    }
}
