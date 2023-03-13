package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_2573_빙산 {
    private static int N;
    private static int M;
    private static int year = 0;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[] cnt;

    private static int[][] map;
    private static boolean[][] visited;

    private static List<Point> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        process();

        System.out.println(year);
    }

    public static void melt(Point p, int index) {
        int nowX = p.x;
        int nowY = p.y;

        int k = 0;

        for(int d=0; d<4; d++) {
            int nextX = nowX + dx[d];
            int nextY = nowY + dy[d];

            if(outofmapCheck(nextX, nextY))
                continue;

            if(!oceanCheck(nextX, nextY))
                continue;

            k++;
        }

        cnt[index] = k;
    }

    public static void process() {
        while(true) {
            if(check())
                break;

            for(int i=0; i<list.size(); i++)
                melt(list.get(i), i);

            for(int i=0; i<list.size(); i++) {
                if(map[list.get(i).x][list.get(i).y] < cnt[i])
                    map[list.get(i).x][list.get(i).y] = 0;
                else
                    map[list.get(i).x][list.get(i).y] -= cnt[i];
            }

            year++;
        }
    }

    public static boolean check() {
        list = new ArrayList<>();
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0)
                    list.add(new Point(i, j));
            }
        }

        if(list.size() == 0) {
            year = 0;
            return true;
        }


        cnt = new int[list.size()];

        Queue<Point> queue = new LinkedList<>();
        queue.offer(list.get(0));
        visited[list.get(0).x][list.get(0).y] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;

            for(int d=0; d<4; d++) {
                int nextX = nowX + dx[d];
                int nextY = nowY + dy[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(oceanCheck(nextX, nextY))
                    continue;

                if(visited[nextX][nextY])
                    continue;

                queue.offer(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }

        for (Point point : list) {
            if (!visited[point.x][point.y])
                return true;
        }

        return false;
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=N || y>=M;
    }

    public static boolean oceanCheck(int x, int y) {
        return map[x][y] == 0;
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