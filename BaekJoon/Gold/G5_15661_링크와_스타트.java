package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_15661_링크와_스타트 {

    static int N, min;

    static boolean[] visited;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        visited = new boolean[N];

        backtracking(0);

        System.out.println(min);
    }

    static void backtracking(int depth) {
        if(depth == N) {
            int start = 0;
            int link = 0;

            for(int i=0; i<N; i++) {
                for(int j=i+1; j<N; j++) {
                    if(visited[i] != visited[j])
                        continue;

                    if(!visited[i])
                        start += (arr[i][j] + arr[j][i]);
                    else
                        link += (arr[i][j] + arr[j][i]);
                }
            }

            min = Math.min(min, Math.abs(start - link));

            return;
        }

        visited[depth] = true;
        backtracking(depth+1);
        visited[depth] = false;
        backtracking(depth+1);
    }
}
