package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G4_11559_Puyo_Puyo {
    private static int result = 0;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static char[][] field;
    private static boolean[][] visited;

    private static List<Point> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[12][6];
        visited = new boolean[12][6];

        for(int i=0; i<12; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                field[i][j] = input.charAt(j);
        }

        Process();

        System.out.println(result);
    }

    public static void Process() {
        while(true) {
            boolean check = false;
            visited = new boolean[12][6];

            for(int i=0; i<12; i++) {
                for(int j=0; j<6; j++) {
                    if(field[i][j] != '.') {
                        list = new ArrayList<>();

                        BFS(i, j);

                        if(list.size() >= 4) {
                            check = true;

                            for(int k=0; k<list.size(); k++)
                                field[list.get(k).x][list.get(k).y] = '.';
                        }
                    }
                }
            }

            if(!check)
                break;
            else {
                drop();
                result++;
            }
        }
    }

    public static void BFS(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY, 0));

        list.add(new Point(startX, startY));

        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            Point nowP = queue.poll();
            char nowColor = field[nowP.x][nowP.y];

            for(int d=0; d<4; d++) {
                int nextX = nowP.x + dx[d];
                int nextY = nowP.y + dy[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(!sameColorCheck(nextX, nextY, nowColor))
                    continue;

                if(visited[nextX][nextY])
                    continue;

                queue.offer(new Point(nextX, nextY, nowP.cnt+1));
                list.add(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }
    }

    public static void drop() {
        for(int i=0; i<6; i++) {
            for(int j=11; j>=0; j--) {
                if(field[j][i] == '.') {
                    for(int k=j-1; k>=0; k--) {
                        if(field[k][i] != '.') {
                            field[j][i] = field[k][i];
                            field[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static boolean sameColorCheck(int x, int y, char nowColor) {
        return field[x][y] == nowColor;
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=12 || y>=6;
    }

    public static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
