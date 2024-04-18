package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_2018_수들의_합_5 {

    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        cnt = 0;

        solve();

        System.out.println(cnt);
    }

    static void solve() {
        for(int i=1; i<=N; i++) {
            int sum = 0;
            int idx = i;

            while(true) {
                sum += idx;

                if(sum == N)
                    cnt++;
                else if(sum > N)
                    break;
                else
                    idx++;
            }
        }
    }
}
