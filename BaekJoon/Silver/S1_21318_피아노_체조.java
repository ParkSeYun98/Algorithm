package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_21318_피아노_체조 {

    static int N, Q;

    static int[] level, mistake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        level = new int[N+1];
        mistake = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
            int now = Integer.parseInt(st.nextToken());
            level[i] = now;

            if(level[i-1] > now)
                mistake[i] = mistake[i-1] + 1;
            else
                mistake[i] = mistake[i-1];
        }

        Q = Integer.parseInt(br.readLine());

        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            System.out.println(mistake[y] - mistake[x]);
        }
    }
}
