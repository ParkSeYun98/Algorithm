package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_2675_문자열_반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            int repeat = Integer.parseInt(st.nextToken());
            String QR = st.nextToken();

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<QR.length(); i++) {
                for(int j=0; j<repeat; j++)
                    sb.append(QR.charAt(i));
            }

            System.out.println(sb.toString());
        }
    }
}
