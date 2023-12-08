package Programmers.JAVA.Lv_2;

import java.util.*;

class Lv_2_PCCP_기출문제_2번_석유_시추 {
    private static int max = -1;

    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    private int[] columnOilAmount;

    private boolean[][] visited;

    public int solution(int[][] land) {
        int oilIdx = 0;

        columnOilAmount = new int[land[0].length];

        visited = new boolean[land.length][land[0].length];

        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                if(!visited[i][j] && land[i][j] == 1)
                    BFS(land, new Point(i, j), ++oilIdx);
            }
        }

        return max;
    }

    public void BFS(int[][] land, Point startP, int oilIdx) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(startP);
        visited[startP.r][startP.c] = true;

        boolean visitedColumn[] = new boolean[land[0].length];
        visitedColumn[startP.c] = true;
        land[startP.r][startP.c] = oilIdx;

        int oilCnt = 1;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC, land))
                    continue;

                if(!oilCheck(nextR, nextC, land))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
                oilCnt++;
                visitedColumn[nextC] = true;
                land[nextR][nextC] = oilIdx;
            }
        }

        getMaxOilAmount(land, visitedColumn, oilCnt);
    }

    public boolean outOfMapCheck(int r, int c, int[][] land) {
        return r<0 || c<0 || r>=land.length || c>=land[0].length;
    }

    public boolean oilCheck(int r, int c, int[][] land) {
        return land[r][c] == 1;
    }

    public void getMaxOilAmount(int[][] land, boolean[] visitedColumn, int oilCnt) {
        for(int i=0;i<land[0].length;i++){
            if(visitedColumn[i]){
                columnOilAmount[i] += oilCnt;
                max = Math.max(max, columnOilAmount[i]);
            }
        }
    }

    public class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}