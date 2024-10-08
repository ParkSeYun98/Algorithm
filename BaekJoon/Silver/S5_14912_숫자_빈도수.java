package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_14912_숫자_빈도수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int cnt = 0;

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
