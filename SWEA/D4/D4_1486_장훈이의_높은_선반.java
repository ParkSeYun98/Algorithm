package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1486_장훈이의_높은_선반 {
    private static int N;
    private static int B;
    private static int min;

    private static int[] customers;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            customers = new int[N];
            int sum = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++) {
                int customer = Integer.parseInt(st.nextToken());
                customers[i] = customer;
                sum += customer;
            }

            if(sum < B) {
                System.out.println("#" + tc + " " + 0);
                continue;
            }

            visited = new boolean[N];
            min = Integer.MAX_VALUE;

            DFS(0, 0);

            System.out.println("#" + tc + " " + min);
        }
    }

    public static void DFS(int idx, int partSum) {
        if(check(partSum)) {
            min = Math.min(min, Math.abs(partSum - B));
            return;
        }

        for(int i=idx; i<customers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(i+1, partSum + customers[i]);
                visited[i] = false;
            }
        }
    }

    public static boolean check(int partSum) {
        return partSum >= B;
    }
}
