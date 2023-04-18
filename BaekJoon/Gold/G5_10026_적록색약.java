package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_10026_적록색약 {
    static int N;

    static int[] dr = {0, 0 ,1 ,-1};
    static int[] dc = {1, -1, 0, 0};

    static char[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        area = new char[N][N];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                area[i][j] = input.charAt(j);
        }

        int cntA = 0;
        int cntB = 0;
        boolean[][] visitedA = new boolean[N][N];
        boolean[][] visitedB = new boolean[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visitedA[i][j]) {
                    BFS(i, j, area[i][j], visitedA, 1);
                    cntA++;
                }

                if(!visitedB[i][j]) {
                    BFS(i, j, area[i][j], visitedB, 2);
                    cntB++;
                }
            }
        }

        System.out.println(cntA + " " + cntB);
    }

    static void BFS(int startR, int startC, char color, boolean[][] visited, int idx) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startR, startC));

        visited[startR][startC] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outofmapCheck(nextR, nextC))
                    continue;

                if(idx == 1) {
                    if(area[nextR][nextC] != color)
                        continue;
                }
                else {
                    if(color == 'B' && area[nextR][nextC] != color)
                        continue;

                    if(color == 'R' && area[nextR][nextC] == 'B')
                        continue;

                    if(color == 'G' && area[nextR][nextC] == 'B')
                        continue;
                }

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
            }
        }
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
