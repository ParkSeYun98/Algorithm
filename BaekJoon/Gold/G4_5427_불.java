package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_5427_불 {

    private static int w;
    private static int h;
    private static Point startP;
    private static int result;

    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};

    private static char[][] map;
    private static boolean[][] fireVisited;

    private static Queue<Point> fireQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            result = 0;
            map = new char[h][w];
            fireVisited = new boolean[h][w];
            fireQueue = new LinkedList<>();

            for(int i=0; i<h; i++) {
                String temp = br.readLine();

                for(int j=0; j<temp.length(); j++) {
                    map[i][j] = temp.charAt(j);

                    if(map[i][j] == '@') {
                        startP = new Point(i, j, 0);
                    }
                    else if(map[i][j] == '*') {
                        fireQueue.offer(new Point(i, j, 0));
                        fireVisited[i][j] = true;
                    }
                }
            }

            BFS();

            if(result == 0)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(result);
        }
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(startP);

        boolean[][] visited = new boolean[h][w];
        visited[startP.r][startP.c] = true;

        while(!queue.isEmpty()) {
            int fireSize = fireQueue.size();

            for(int i=0; i<fireSize; i++) {
                Point nowFire = fireQueue.poll();

                for(int d=0; d<4; d++) {
                    int nextFireR = nowFire.r + dr[d];
                    int nextFireC = nowFire.c + dc[d];

                    if(outofmapCheck(nextFireR, nextFireC))
                        continue;

                    if(wallCheck(nextFireR, nextFireC))
                        continue;

                    if(fireCheck(nextFireR, nextFireC))
                        continue;

                    if(fireVisited[nextFireR][nextFireC])
                        continue;

                    fireQueue.offer(new Point(nextFireR, nextFireC, 0));
                    fireVisited[nextFireR][nextFireC] = true;
                    map[nextFireR][nextFireC] = '*';
                }
            }

            int playerSize = queue.size();

            for(int i=0; i<playerSize; i++) {
                Point now = queue.poll();

                for(int d=0; d<4; d++) {
                    int nextR = now.r + dr[d];
                    int nextC = now.c + dc[d];

                    if(outofmapCheck(nextR, nextC)) {
                        result = now.cnt + 1;

                        return;
                    }

                    if(wallCheck(nextR, nextC))
                        continue;

                    if(fireCheck(nextR, nextC))
                        continue;

                    if(visited[nextR][nextC])
                        continue;

                    queue.offer(new Point(nextR, nextC, now.cnt + 1));
                    visited[nextR][nextC] = true;
                    map[nextR][nextC] = '@';
                }
            }
        }
    }

    public static boolean outofmapCheck(int r, int c) {
        return r < 0 || c < 0 || r >= h || c >= w;
    }

    public static boolean wallCheck(int r, int c) {
        return map[r][c] == '#';
    }

    public static boolean fireCheck(int r, int c) {
        return map[r][c] == '*';
    }

    public static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
