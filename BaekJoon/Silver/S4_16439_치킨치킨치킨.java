package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_16439_치킨치킨치킨 {

    static int N, M, max;

    static boolean[] visited;

    static int[][] chickenScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chickenScore = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++)
                chickenScore[i][j] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        visited = new boolean[M];

        getMaxScore(0, 0);

        System.out.println(max);
    }

    static void getMaxScore(int depth, int start) {
        if(depth >= 3) {
            int sum = 0;

            for(int i=0; i<N; i++) {
                int tmp = 0;

                for(int j=0; j<M; j++) {
                    if(visited[j])
                        tmp = Math.max(tmp, chickenScore[i][j]);
                }

                sum += tmp;
            }

            max = Math.max(sum, max);

            return;
        }

        for(int i=start; i<M; i++) {
            if(!visited[i]) {
                visited[i] = true;
                getMaxScore(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
