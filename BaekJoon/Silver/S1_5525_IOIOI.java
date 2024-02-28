package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_5525_IOIOI {

    static int N, M;
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        solve();
    }

    static void solve() {
        int cnt = 0;
        int temp = 0;

        for(int i=1; i<M-1;) {
            if(S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
                temp++;

                if(temp == N) {
                    if(S.charAt(i - ((2*temp)-1)) == 'I')
                        cnt++;
                    temp--;
                }

                i+=2;
            }
            else {
                temp = 0;
                i++;
            }
        }

        System.out.println(cnt);
    }
}
