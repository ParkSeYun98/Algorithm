package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_1226_미로1 {
    private static int result;

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static int[][] maze;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=1; tc<=10; tc++) {
            int T = Integer.parseInt(br.readLine());

            maze = new int[16][16];
            visited = new boolean[16][16];

            int startX = -1;
            int startY = -1;

            for(int i=0; i<16; i++) {
                String input = br.readLine();

                for(int j=0; j<input.length(); j++) {
                    int temp = input.charAt(j) - '0';
                    maze[i][j] = temp;

                    if(temp == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            result = 0;
            visited[startX][startY] = true;

            DFS(startX, startY);

            System.out.println("#" + T + " " + result);
        }
    }

    public static void DFS(int x, int y) {
        if(maze[x][y] == 3) {
            result = 1;
        }

        for(int d=0; d<4; d++) {
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if(outofmapCheck(nextX, nextY))
                continue;

            if(wallCheck(nextX, nextY))
                continue;

            if(visited[nextX][nextY])
                continue;

            visited[nextX][nextY] = true;
            DFS(nextX, nextY);
            visited[nextX][nextY] = false;
        }
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=16 || y>=16;
    }

    public static boolean wallCheck(int x, int y) {
        return maze[x][y] == 1;
    }
}
