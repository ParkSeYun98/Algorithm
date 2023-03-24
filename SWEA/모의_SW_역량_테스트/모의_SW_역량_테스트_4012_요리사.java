package SWEA.모의_SW_역량_테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의_SW_역량_테스트_4012_요리사 {
    private static int N;
    private static int min;

    private static boolean[] visited;

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            visited = new boolean[N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<N; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;
            cook(0, 0);

            System.out.println("#" + tc + " " + min);
        }
    }

    public static void cook(int depth, int idx) {
        if(depth == N/2) {
            int Ascore = 0;
            int Bscore = 0;

            for(int i=0; i<N-1; i++) {
                for(int j=i+1; j<N; j++) {
                    if(visited[i] && visited[j])
                        Ascore += (arr[i][j] + arr[j][i]);
                    else if(!visited[i] && !visited[j])
                        Bscore += (arr[i][j] + arr[j][i]);
                }
            }

            int diff = Math.abs(Ascore - Bscore);

            min = Math.min(min, diff);

            return;
        }

        for(int i=idx; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                cook(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}