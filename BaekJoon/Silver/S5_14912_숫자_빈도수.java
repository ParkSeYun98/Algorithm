package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_14912_숫자_빈도수 {

    static int n, d, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        cnt = 0;

        for(int i=1; i<=n; i++) {
            String now = String.valueOf(i);

            for(int j=0; j<now.length(); j++) {
                int num = now.charAt(j) - '0';

                if(num == d)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}
