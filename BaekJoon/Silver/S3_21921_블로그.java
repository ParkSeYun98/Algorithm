package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_21921_블로그 {

    static int N, X;

    static int[] blogReport;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        blogReport = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            blogReport[i] = Integer.parseInt(st.nextToken());

        analysis();
    }

    static void analysis() {
        int now = 0;
        int maxDay = 1;

        for(int i=0; i<X; i++)
            now += blogReport[i];

        int max = now;

        for(int i=X; i<N; i++) {
            now -= blogReport[i-X];
            now += blogReport[i];

            if(max == now)
                maxDay++;
            else if(max < now) {
                max = now;
                maxDay = 1;
            }
        }

        if(max == 0)
            System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(maxDay);
        }
    }
}
