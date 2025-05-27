package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11504_돌려_돌려_돌림판 {

    static int N, M, X, Y, cnt;

    static String circle, now;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            String strX = "";
            String strY = "";

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<M; i++)
                strX += st.nextToken();

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<M; i++)
                strY += st.nextToken();

            X = Integer.parseInt(strX);
            Y = Integer.parseInt(strY);

            circle = "";

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++)
                circle += st.nextToken();

            int idx = 0;
            cnt = 0;

            for(int i=0; i<N; i++) {
                while(i+M >= circle.length()) {
                    circle += circle.charAt(idx);
                    idx++;
                }

                now = "";

                for(int j=i; j<i+M; j++)
                    now += Character.toString(circle.charAt(j));

                if(Integer.parseInt(now) >= X && Integer.parseInt(now) <= Y)
                    cnt++;
            }

            System.out.println(cnt);
        }
    }
}
