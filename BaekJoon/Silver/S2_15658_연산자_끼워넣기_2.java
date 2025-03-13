package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_15658_연산자_끼워넣기_2 {

    static int N, min, max;

    static int[] A, operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        operator = new int[4];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++)
            operator[i] = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        backtracking(1, A[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void backtracking(int depth, int sum) {
        if(depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);

            return;
        }

        for(int i=0; i<4; i++) {
            if(operator[i] > 0) {
                operator[i]--;

                switch(i) {
                    case 0 :
                        backtracking(depth+1, sum + A[depth]);
                        break;
                    case 1:
                        backtracking(depth+1, sum - A[depth]);
                        break;
                    case 2:
                        backtracking(depth+1, sum * A[depth]);
                        break;
                    case 3:
                        backtracking(depth+1, sum / A[depth]);
                        break;
                }

                operator[i]++;
            }
        }
    }
}
