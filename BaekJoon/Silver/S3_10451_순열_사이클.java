package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_10451_순열_사이클 {
    private static int N;
    private static int cycle;

    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N+1];
            visited = new boolean[N+1];
            arr[0] = -1;

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=1; i<=N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            cycle = 0;

            for(int i=1; i<=N; i++) {
                if(!visited[i]) {
                    getCycle(i);
                    cycle++;
                }
            }

            System.out.println(cycle);
        }
    }

    public static void getCycle(int start) {
        if(!visited[start]) {
            visited[start] = true;
            getCycle(arr[start]);
        }
    }
}