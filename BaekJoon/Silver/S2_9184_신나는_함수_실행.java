package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_9184_신나는_함수_실행 {

    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dp = new int[21][21][21];

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1)
                break;

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + func(a, b, c));
        }
    }

    static int func(int a, int b, int c) {
        if(a>=0 && b>=0 && c>=0 && a<=20 && b<=20 && c<=20 && dp[a][b][c]!=0)
            return dp[a][b][c];

        if(a<=0 || b<=0 || c<=0)
            return 1;

        if(a>20 || b>20 || c>20) {
            dp[20][20][20] = func(20, 20, 20);
            return dp[20][20][20];
        }

        if(a<b && b<c) {
            dp[a][b][c] = func(a, b, c-1) + func(a, b-1, c-1) - func(a, b-1, c);
            return dp[a][b][c];
        }

        dp[a][b][c] = func(a-1, b, c) + func(a-1, b-1, c) + func(a-1, b, c-1) - func(a-1, b-1, c-1);
        return dp[a][b][c];
    }
}
