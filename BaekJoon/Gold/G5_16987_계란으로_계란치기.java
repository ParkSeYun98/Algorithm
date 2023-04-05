package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_16987_계란으로_계란치기 {
    static int N;
    static int max = 0;

    static int[] S;
    static int[] W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        S = new int[N];
        W = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            S[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
        }

        breakEgg(0, 0);

        System.out.println(max);
    }

    static void breakEgg(int depth, int cnt) {
        if(depth == N) {
            max = Math.max(max, getBrokenEgg());
            return;
        }

        if(S[depth] <= 0) {
            breakEgg(depth + 1, cnt);
            return;
        }

        for(int i=0; i<N; i++) {
            if(S[depth] > 0 && S[i] > 0 && depth != i) {
                cnt++;
                S[depth] -= W[i];
                S[i] -= W[depth];
                breakEgg(depth + 1, cnt);
                S[i] += W[depth];
                S[depth] += W[i];
                cnt--;
            }
            else if(cnt >= 1)
                breakEgg(depth + 1, cnt);
        }
    }

    static int getBrokenEgg() {
        int cnt = 0;

        for (int hp : S) {
            if (hp <= 0)
                cnt++;
        }

        return cnt;
    }
}
