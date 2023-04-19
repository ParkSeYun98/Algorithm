package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_6593_상범_빌딩 {
    static int L;
    static int R;
    static int C;
    static Point startP;
    static Point endP;

    static final int[] dh = {0, 0, 0, 0, 1, -1};
    static final int[] dr = {0, 0, 1, -1, 0, 0};
    static final int[] dc = {1, -1, 0, 0, 0, 0};

    static char[][][] building;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L==0 && R==0 && C==0)
                break;

            building = new char[L][R][C];

            for(int i=0; i<L; i++) {
                for(int j=0; j<R; j++) {
                    String input = br.readLine();

                    for(int k=0; k<input.length(); k++) {
                        building[i][j][k] = input.charAt(k);

                        if(building[i][j][k] == 'S')
                            startP = new Point(i, j, k, 0);
                        else if(building[i][j][k] == 'E')
                            endP = new Point(i, j, k, 0);
                    }
                }

                br.readLine();
            }

            BFS();
        }
    }

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(startP);

        boolean[][][] visited = new boolean[L][R][C];
        visited[startP.h][startP.r][startP.c] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(building[now.h][now.r][now.c] == 'E') {
                System.out.println("Escaped in " + now.t + " minute(s).");
                return;
            }

            for(int d=0; d<6; d++) {
                int nextH = now.h + dh[d];
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outofmapCheck(nextH, nextR, nextC))
                    continue;

                if(wallCheck(nextH, nextR, nextC))
                    continue;

                if(visited[nextH][nextR][nextC])
                    continue;

                queue.offer(new Point(nextH, nextR, nextC, now.t + 1));
                visited[nextH][nextR][nextC] = true;
            }
        }

        System.out.println("Trapped!");
    }

    static boolean outofmapCheck(int h, int r, int c) {
        return h<0 || r<0 || c<0 || h>=L || r>=R || c>=C;
    }

    static boolean wallCheck(int h, int r, int c) {
        return building[h][r][c] == '#';
    }

    static class Point {
        int h;
        int r;
        int c;
        int t;

        public Point(int h, int r, int c, int t) {
            this.h = h;
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
}
