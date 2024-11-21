package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_11558_The_Game_of_Death {

    static int N;

    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());

            A = new int[N+1];

            for(int i=1; i<=N; i++)
                A[i] = Integer.parseInt(br.readLine());

            int now = 1;
            int cnt = 0;
            boolean flag = true;
            boolean[] visited = new boolean[N+1];

            while(true) {
                if(now == N)
                    break;

                if(visited[now]) {
                    flag = false;
                    break;
                }

                visited[now] = true;
                now = A[now];
                cnt++;
            }

            if(!flag)
                System.out.println(0);
            else
                System.out.println(cnt);
        }
    }
}
