package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1915_가장_큰_정사각형 {

    static int n, m;

    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int max = 0;
        arr = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                arr[i][j+1] = input.charAt(j) - '0';
        }

        dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + arr[i][j] - dp[i-1][j-1];
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(arr[i][j] == 1) {
                    int result = 1;
                    int idx = 1;

                    while(true) {
                        if((i+idx)>n || (j+idx)>m)
                            break;

                        int sum = dp[i+idx][j+idx] - dp[i+idx][j-1] - dp[i-1][j+idx] + dp[i-1][j-1];
                        idx++;

                        if(sum != idx*idx)
                            break;

                        result = idx*idx;
                    }

                    max = Math.max(max, result);
                }
            }
        }

        System.out.println(max);
    }
}
