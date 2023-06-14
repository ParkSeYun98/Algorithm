package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_게임_맵_최단거리 {
    class Solution {
        int result = -1;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public int solution(int[][] maps) {

            BFS(maps);

            return result;
        }

        void BFS(int[][] maps) {
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0, 0, 1));

            boolean[][] visited = new boolean[maps.length][maps[0].length];
            visited[0][0] = true;

            while(!queue.isEmpty()) {
                Point now = queue.poll();

                if(now.x == maps.length-1 && now.y == maps[0].length-1) {
                    result = now.cnt;
                    return;
                }

                for(int d=0; d<4; d++) {
                    int nextX = now.x + dx[d];
                    int nextY = now.y + dy[d];

                    if(outofmapCheck(nextX, nextY, maps))
                        continue;

                    if(wallCheck(nextX, nextY, maps))
                        continue;

                    if(visited[nextX][nextY])
                        continue;

                    visited[nextX][nextY] = true;
                    queue.offer(new Point(nextX, nextY, now.cnt+1));
                }
            }
        }

        boolean outofmapCheck(int x, int y, int[][] maps) {
            return x<0 || y<0 || x>=maps.length || y>=maps[0].length;
        }

        boolean wallCheck(int x, int y, int[][] maps) {
            return maps[x][y] == 0;
        }

        class Point {
            int x;
            int y;
            int cnt;

            public Point(int x, int y, int cnt) {
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }
    }
}
