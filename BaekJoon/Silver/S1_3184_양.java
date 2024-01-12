package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_3184_양 {

    static int R;
    static int C;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static char[][] garden;
    static boolean[][] visited;

    static List<Point> sheepList;
    static List<Point> wolfList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        garden = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String temp = br.readLine();

            for(int j=0; j<temp.length(); j++)
                garden[i][j] = temp.charAt(j);
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(garden[i][j] == 'v' || garden[i][j] == 'o') {
                    sheepList = new ArrayList<>();
                    wolfList = new ArrayList<>();

                    if(!visited[i][j]) {
                        fight(new Point(i, j));

                        if(wolfList.size() < sheepList.size()) {
                            for (Point point : wolfList)
                                garden[point.r][point.c] = '.';
                        }
                        else {
                            for (Point point : sheepList)
                                garden[point.r][point.c] = '.';
                        }
                    }
                }
            }
        }

        int wolfCnt = 0;
        int sheepCnt = 0;

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(garden[i][j] == 'o')
                    sheepCnt++;
                else if(garden[i][j] == 'v')
                    wolfCnt++;
            }
        }

        System.out.println(sheepCnt + " " + wolfCnt);
    }

    static void fight(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.r][start.c] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(garden[now.r][now.c] == 'v')
                wolfList.add(now);
            else if(garden[now.r][now.c] == 'o')
                sheepList.add(now);

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(wallCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
            }
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=R || c>=C;
    }

    static boolean wallCheck(int r, int c) {
        return garden[r][c] == '#';
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
