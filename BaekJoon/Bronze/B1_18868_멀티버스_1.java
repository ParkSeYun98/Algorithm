package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B1_18868_멀티버스_1 {

    static int M, N;

    static int[][] planet;
    static String[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        planet = new int[M][N];
        check = new String[M];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++)
                planet[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            StringBuilder sb = new StringBuilder();

            for(int j=1; j<N; j++) {
                for(int k=1; k<=j; k++) {
                    if(planet[i][j] > planet[i][j-k])
                        sb.append("1");
                    else if(planet[i][j] < planet[i][j-k])
                        sb.append("-1");
                    else
                        sb.append("0");
                }
            }

            check[i] = sb.toString();
        }

        int cnt = 0;

       for(int i=0; i<M-1; i++) {
           for(int j=i+1; j<M; j++) {
               if(check[i].equals(check[j]))
                   cnt++;
           }
       }

        System.out.println(cnt);
    }
}
