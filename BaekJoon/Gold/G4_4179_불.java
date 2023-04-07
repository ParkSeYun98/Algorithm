package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_4179_불 {
    static int R;
    static int C;

    static final int[] dr = {1, -1, 0, 0};
    static final int[] dc = {0, 0, 1, -1};

    static char[][] maze;
    static boolean[][] jihunVisited;
    static boolean[][] fireVisited;

    static Queue<Point> jihunQueue = new LinkedList<>();
    static Queue<Point> fireQueue = new LinkedList<>();

    static List<Point> jihunList = new ArrayList<>();
    static List<Point> fireList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        maze = new char[R][C];
        jihunVisited = new boolean[R][C];
        fireVisited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++) {
                maze[i][j] = input.charAt(j);

                if(maze[i][j] == 'J') {
                    jihunList.add(new Point(i, j));
                    jihunVisited[i][j] = true;
                }
                else if(maze[i][j] == 'F') {
                    fireList.add(new Point(i, j));
                    fireVisited[i][j] = true;
                }
            }
        }

        BFS();
    }

    static void BFS() {
        int time = 1;

        while(true) {
            if(jihunList.size() == 0 && fireList.size() == 0) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            for(int i=jihunList.size()-1; i>=0; i--) {
                jihunQueue.offer(jihunList.get(i));
                jihunList.remove(i);
            }

            for(int i=fireList.size()-1; i>=0; i--) {
                fireQueue.offer(fireList.get(i));
                fireList.remove(i);
            }

            while(!fireQueue.isEmpty()) {
                Point now = fireQueue.poll();

                for(int d=0; d<4; d++) {
                    int nextR = now.r + dr[d];
                    int nextC = now.c + dc[d];

                    if(outofmapCheck(nextR, nextC))
                        continue;

                    if(wallCheck(nextR, nextC))
                        continue;

                    if(fireVisited[nextR][nextC])
                        continue;

                    fireList.add(new Point(nextR, nextC));
                    fireVisited[nextR][nextC] = true;
                    maze[nextR][nextC] = 'F';
                }
            }

            while(!jihunQueue.isEmpty()) {
                Point now = jihunQueue.poll();

                for(int d=0; d<4; d++) {
                    int nextR = now.r + dr[d];
                    int nextC = now.c + dc[d];

                    if(outofmapCheck(nextR, nextC)) {
                        System.out.println(time);
                        return;
                    }

                    if(wallCheck(nextR, nextC))
                        continue;

                    if(fireCheck(nextR, nextC))
                        continue;

                    if(jihunVisited[nextR][nextC])
                        continue;

                    jihunList.add(new Point(nextR, nextC));
                    jihunVisited[nextR][nextC] = true;
                    maze[nextR][nextC] = 'J';
                }
            }

            time++;
        }
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=R || c>=C;
    }

    static boolean wallCheck(int r, int c) {
        return maze[r][c] == '#';
    }

    static boolean fireCheck(int r, int c) {
        return maze[r][c] == 'F';
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
