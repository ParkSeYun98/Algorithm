package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_20950_미술가_미미 {

    static int N, min;

    static int[] R, G, B, goal, now, perm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        R = new int[N];
        G = new int[N];
        B = new int[N];
        goal = new int[3];
        perm = new int[N];
        now = new int[3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<3; i++)
            goal[i] = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;

        for(int i=2; i<=N; i++) {
            if(i>7)
                break;

            permutation(0, 0, i);
        }

        System.out.println(min);
    }

    static void permutation(int depth, int start, int limit) {
        if(depth == limit) {
            mix(limit);
            min = Math.min(min, getGap());
            return;
        }

        for(int i=start; i<N; i++) {
            perm[depth] = i;
            permutation(depth+1, i+1, limit);
        }
    }

    static void mix(int limit) {
        now = new int[3];

        for(int i=0; i<limit; i++) {
            now[0] += R[perm[i]];
            now[1] += G[perm[i]];
            now[2] += B[perm[i]];
        }

        for(int i=0; i<3; i++)
            now[i] /= limit;
    }

    static int getGap() {
        int sum = 0;

        for(int i=0; i<3; i++)
            sum += Math.abs(now[i] - goal[i]);

        return sum;
    }
}
