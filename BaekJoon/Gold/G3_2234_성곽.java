package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_2234_성곽 {
    private static int N;
    private static int M;
    private static int roomCnt = 0;
    private static int maxSize = 0;
    private static int onewallbreakmaxSize = 0;

    // 서 북 동 남
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};

    private static int[][] map;
    private static boolean[][] visited;
    private static int[][][] wallCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];
        wallCnt = new int[M][N][2];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    BFS(i, j, roomCnt);
                    roomCnt++;
                }
            }
        }

        brokeBFS();

        System.out.println(roomCnt);
        System.out.println(maxSize);
        System.out.println(onewallbreakmaxSize);
    }

    public static void BFS(int startX, int startY, int roomcnt) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));
        visited[startX][startY] = true;
        List<Point> list = new LinkedList<>();
        int tmp = 0;

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            list.add(now);
            tmp++;
            maxSize = Math.max(maxSize, tmp);

            for(int d=0; d<4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(visited[nextX][nextY])
                    continue;

                if(nowallCheck(now.x, now.y, d)) {
                    queue.offer(new Point(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }

        for(int i=0; i<list.size(); i++) {
            wallCnt[list.get(i).x][list.get(i).y][0] = roomcnt;
            wallCnt[list.get(i).x][list.get(i).y][1] = tmp;
        }
    }

    public static void brokeBFS() {
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                for(int d=0; d<4; d++) {
                    int nextX = i + dx[d];
                    int nextY = j + dy[d];

                    if(outofmapCheck(nextX, nextY))
                        continue;

                    // 현재 방과 next방의 roomcnt가 다르다면, (벽으로 구분된 다른 방이라면)
                    // 두 방의 방 최대 크기의 합이 벽을 허물었을 때 두 방이 합쳐진 새로운 방의 최대 크기 합이 된다.
                    if(wallCnt[i][j][0] != wallCnt[nextX][nextY][0])
                        onewallbreakmaxSize = Math.max(onewallbreakmaxSize, wallCnt[i][j][1] + wallCnt[nextX][nextY][1]);

                }
            }
        }
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=M || y>=N;
    }

    public static boolean nowallCheck(int x, int y, int d) {
        return (map[x][y] & (1 << d)) == 0;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
