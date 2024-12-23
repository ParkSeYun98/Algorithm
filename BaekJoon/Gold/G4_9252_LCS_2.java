package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G4_9252_LCS_2 {

    static String strA, strB;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        strA = br.readLine();
        strB = br.readLine();

        dp = new int[strA.length()+1][strB.length()+1];

        makeDP();
        getLCS();
    }

    static void makeDP() {
        for(int i=1; i<=strA.length(); i++) {
            for(int j=1; j<=strB.length(); j++) {
                if(strA.charAt(i-1) == strB.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }

    static void getLCS() {
        Stack<Character> stack = new Stack<>();

        int i = strA.length();
        int j = strB.length();

        while(true) {
            if(i==0 && j==0)
                break;

            if(i<=0 || j<=0)
                break;

            if(dp[i][j] == dp[i-1][j])
                i--;
            else if(dp[i][j] == dp[i][j-1])
                j--;
            else {
                stack.push(strA.charAt(i-1));
                i--;
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty())
            sb.append(stack.pop());

        System.out.println(sb.length());
        System.out.println(sb);
    }
}
