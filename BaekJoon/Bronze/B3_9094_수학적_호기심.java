package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_9094_수학적_호기심 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            program(n, m);
        }


    }

    static void program(int n, int m) {
        int cnt = 0;

        for(int i=1; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if((Math.pow(i, 2)+Math.pow(j, 2)+m) % (i*j) == 0)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}
