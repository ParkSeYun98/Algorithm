package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_11501_주식 {

    private static int T;
    private static int N;

    private static int[] days;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());

            days = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++)
                days[i] = Integer.parseInt(st.nextToken());

            long earn = 0;
            int max = days[N-1];

            for(int i=N-2; i>=0; i--) {
                if(days[i] < max)
                    earn += max - days[i];
                else {
                    max = days[i];
                }
            }

            System.out.println(earn);
        }
    }
}