package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_7562_나이트의_이동 {
    static int I;
    static int cnt;
    static Point startP;
    static Point endP;

    static final int[] dr = {-2, 1, 2, 1, 2, -1, -2, -1};
    static final int[] dc = {1, -2, 1, 2, -1, 2, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            I = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            startP = new Point(startR, startC);

            st = new StringTokenizer(br.readLine(), " ");
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());
            endP = new Point(endR, endC);

            cnt = 0;

            BFS();
        }
    }

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();

        List<Point> list = new ArrayList<>();
        list.add(startP);

        boolean[][] visited = new boolean[I][I];
        visited[startP.r][startP.c] = true;

        while(true) {
            if(list.size() == 0) {
                System.out.println(0);
                return;
            }

            for(int i=list.size()-1; i>=0; i--) {
                queue.offer(list.get(i));
                list.remove(i);
            }

            while(!queue.isEmpty()) {
                Point now = queue.poll();

                if(now.r == endP.r && now.c == endP.c) {
                    System.out.println(cnt);
                    return;
                }

                for(int d=0; d<8; d++) {
                    int nextR = now.r + dr[d];
                    int nextC = now.c + dc[d];

                    if(outofmapCheck(nextR, nextC))
                        continue;

                    if(visited[nextR][nextC])
                        continue;

                    visited[nextR][nextC] = true;
                    list.add(new Point(nextR, nextC));
                }
            }

            cnt++;
        }
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=I || c>=I;
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
