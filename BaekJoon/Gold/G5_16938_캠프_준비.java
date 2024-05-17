package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_16938_캠프_준비 {

    static int N, L, R, X, ans;

    static int[] question;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

         st = new StringTokenizer(br.readLine(), " ");

         N = Integer.parseInt(st.nextToken());
         L = Integer.parseInt(st.nextToken());
         R = Integer.parseInt(st.nextToken());
         X = Integer.parseInt(st.nextToken());

         question = new int[N];

         st = new StringTokenizer(br.readLine());

         for(int i=0; i<N; i++)
            question[i] = Integer.parseInt(st.nextToken());

         ans = 0;

         pickQuestion(0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        System.out.println(ans);
    }

    static void pickQuestion(int cnt, int sum, int max, int min, int start) {
        if(cnt >= 2) {
            if(sum >= L && sum <= R && (max - min) >= X)
                ans++;
        }

        for(int i=start; i<N; i++)
            pickQuestion(cnt + 1, sum + question[i], Math.max(max, question[i]), Math.min(min, question[i]), i+1);
    }
}
