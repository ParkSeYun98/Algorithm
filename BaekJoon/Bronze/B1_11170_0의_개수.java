package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1_11170_0의_개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int cnt = 0;

            for(int i=N; i<=M; i++) {
                String now = String.valueOf(i);

                for(int j=0; j<now.length(); j++) {
                    if(now.charAt(j) - '0' == 0)
                        cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
