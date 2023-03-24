package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_17070_파이프_옮기기_1 {
    private static int N;
    private static int cnt = 0;

    // 우 우하 하
    private static final int[] dx = {0, 1, 1};
    private static final int[] dy = {1, 1, 0};

    private static int[][] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        house = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++)
                house[i][j] = Integer.parseInt(st.nextToken());
        }

        // status 0 : 가로, 1 : 대각, 2 : 세로
        DFS(0, 1, 0);

        System.out.println(cnt);
    }


    public static void DFS(int startX, int startY, int status) {
        if(startX == N-1 && startY == N-1) {
            cnt++;
            return;
        }

        int nextStatus = -1;
        int nextX = -1;
        int nextY = -1;

        switch(status) {
            // 가로 상태
            case 0 :
                // 다음 상태 : 가로
                nextStatus = 0;

                nextX = startX + dx[nextStatus];
                nextY = startY + dy[nextStatus];

                if(!outofmapCheck(nextX, nextY) && !wallCheck(nextX, nextY))
                    DFS(nextX, nextY, nextStatus);

                break;

            // 대각 상태
            case 1 :
                // 다음 상태 : 가로
                nextStatus = 0;

                nextX = startX + dx[nextStatus];
                nextY = startY + dy[nextStatus];

                if(!outofmapCheck(nextX, nextY) && !wallCheck(nextX, nextY))
                    DFS(nextX, nextY, nextStatus);


                // 다음 상태 : 세로
                nextStatus = 2;

                nextX = startX + dx[nextStatus];
                nextY = startY + dy[nextStatus];

                if(!outofmapCheck(nextX, nextY) && !wallCheck(nextX, nextY))
                    DFS(nextX, nextY, nextStatus);

                break;

            // 세로 상태
            case 2 :
                // 다음 상태 : 세로
                nextStatus = 2;

                nextX = startX + dx[nextStatus];
                nextY = startY + dy[nextStatus];

                if(!outofmapCheck(nextX, nextY) && !wallCheck(nextX, nextY))
                    DFS(nextX, nextY, nextStatus);

                break;
        }
        
        // 현재 어떤 상태든, 다음 상태 : 대각
        nextStatus = 1;

        nextX = startX + dx[nextStatus];
        nextY = startY + dy[nextStatus];

        if(!outofmapCheck(nextX, nextY) && !wallCheck(nextX, nextY) && !wallCheck(nextX-1, nextY) && !wallCheck(nextX, nextY-1))
            DFS(nextX, nextY, nextStatus);
    }

    public static boolean wallCheck(int x, int y) {
        return house[x][y] == 1;
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=N || y>=N;
    }
}
