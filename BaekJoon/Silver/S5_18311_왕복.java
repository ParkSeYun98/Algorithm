package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_18311_왕복 {

    static int N;
    static long K;

    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        cost = new int[N];
        boolean flag = false;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            cost[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            K -= cost[i];

            if(K < 0) {
                System.out.println(i+1);
                flag = true;
                break;
            }
        }

        if(!flag) {
            for(int i=N-1; i>=0; i--) {
                K -= cost[i];

                if(K < 0) {
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}
