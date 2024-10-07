package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_14650_걷다보니_신천역_삼_Small {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(recursion(N, 1) + recursion(N, 2));
    }

    static int recursion(int N, int now) {
        if(N == 1) {
            if(now%3 == 0)
                return 1;
            else
                return 0;
        }

        int cnt = 0;

        for(int i=0; i<3; i++)
            cnt += recursion(N-1, 10*now + i);

        return cnt;
    }
}
