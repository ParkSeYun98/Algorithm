package SWEA.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_1247_최적_경로 {
    private static int N;
    private static int companyX;
    private static int companyY;
    private static int houseX;
    private static int houseY;
    private static int min;

    private static int[] route;

    private static int[][] customers;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            companyX = Integer.parseInt(st.nextToken());
            companyY = Integer.parseInt(st.nextToken());

            houseX = Integer.parseInt(st.nextToken());
            houseY = Integer.parseInt(st.nextToken());

            customers = new int[N][2];
            visited = new boolean[N];
            route = new int[N];

            for(int i=0; i<N; i++) {
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;

            findRoute(0);

            System.out.println("#" + tc + " " + min);
        }
    }

    public static void findRoute(int depth) {
        if(depth == N) {
            int sum = 0;

            for(int i=0; i<route.length - 1; i++)
                sum += (Math.abs(customers[route[i]][0] - customers[route[i+1]][0]) + Math.abs(customers[route[i]][1] - customers[route[i+1]][1]));

            sum += (Math.abs(customers[route[0]][0] - companyX) + Math.abs(customers[route[0]][1] - companyY));
            sum += (Math.abs(customers[route[route.length-1]][0] - houseX) + Math.abs(customers[route[route.length-1]][1] - houseY));

            min = Math.min(min, sum);

            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                route[depth] = i;
                findRoute(depth+1);
                visited[i] = false;
            }
        }
    }
}
