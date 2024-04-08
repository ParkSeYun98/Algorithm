package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_2636_치즈 {

    static int R, C;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] map;
    static boolean[][] visited;

    static List<Integer> cheeseCntList;

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

        st = new StringTokenizer(br.readLine() ," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int firstCheeseCnt = 0;
        map = new int[R][C];
        cheeseCntList = new ArrayList<>();

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1)
                    firstCheeseCnt++;
            }
        }

        cheeseCntList.add(firstCheeseCnt);
        timeGoesOn();
    }

    static void timeGoesOn() {
        int time = 1;

        while(true) {
            visited = new boolean[R][C];

            int cheeseCnt = BFS(new Point(0, 0));

            if(cheeseCnt != 0)
                cheeseCntList.add(cheeseCnt);
            else
                break;

            time++;
        }

        System.out.println(time);
        System.out.println(cheeseCntList.get(cheeseCntList.size()-1));
    }

    static int BFS(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        visited[start.r][start.c] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                if(map[nextR][nextC] == 0) {
                    queue.offer(new Point(nextR, nextC));
                    visited[nextR][nextC] = true;
                }
                else
                    map[nextR][nextC] = 2;
            }
        }

        return meltCheese();
    }

    static int meltCheese() {
        int cheeseCnt = 0;

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == 2)
                    map[i][j] = 0;
                else if(map[i][j] == 1)
                    cheeseCnt++;
            }
        }

        return cheeseCnt;
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=R || c>=C;
    }
}
