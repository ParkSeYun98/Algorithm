package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_1120_문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();

        int min = Integer.MAX_VALUE;

        for(int i=0; i<=B.length()-A.length(); i++) {
            int cnt = 0;

            for(int j=0; j<A.length(); j++) {
                if(A.charAt(j) != B.charAt(i+j))
                    cnt++;
            }

            min = Math.min(min, cnt);
        }

        System.out.println(min);
    }
}
