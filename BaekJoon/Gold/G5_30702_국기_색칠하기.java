package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_30702_국기_색칠하기 {

    static int N, M;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] mapA = new char[N][M];
        char[][] mapB = new char[N][M];
        int[][] checkMapA = new int[N][M];
        int[][] checkMapB = new int[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                mapA[i][j] = input.charAt(j);
        }

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                mapB[i][j] = input.charAt(j);
        }

        boolean[][] visitedA = new boolean[N][M];
        boolean[][] visitedB = new boolean[N][M];

        int idx1 = 1;
        int idx2 = 1;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visitedA[i][j])
                    BFS(mapA, new Point(i, j), visitedA, idx1++, checkMapA);

                if(!visitedB[i][j])
                    BFS(mapB, new Point(i, j), visitedB, idx2++, checkMapB);
            }
        }

        boolean flag = false;

        outer : for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(checkMapA[i][j] != checkMapB[i][j]) {
                    flag = true;
                    break outer;
                }
            }
        }

        if(flag)
            System.out.println("NO");
        else
            System.out.println("YES");
    }

    static void BFS(char[][] map, Point start, boolean[][] visited, int idx, int[][] checkMap) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        visited[start.r][start.c] = true;

        int num = map[start.r][start.c];

        checkMap[start.r][start.c] = idx;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                if(num != map[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
                checkMap[nextR][nextC] = idx;
            }
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }
}
