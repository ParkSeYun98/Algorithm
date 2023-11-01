package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G5_18428_감시_피하기 {

    private static int N;
    private static boolean answer;

    private static final int[] dr = {0, 0, 1, -1};
    private static final int[] dc = {1, -1, 0, 0};

    private static String[][] map;
    private static boolean[][] visited;

    private static List<Point> teacherList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        answer = false;
        map = new String[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++) {
                map[i][j] = st.nextToken();

                if(map[i][j].equals("T"))
                    teacherList.add(new Point(i, j));
            }
        }

        DFS(0);

        if(answer)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static void DFS(int depth) {
        if(answer)
            return;

        if(depth == 3) {
            check();

            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j].equals("X") && !visited[i][j]) {
                    visited[i][j] = true;
                    map[i][j] = "O";

                    DFS(depth + 1);

                    map[i][j] = "X";
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void check() {
        String[][] tempMap = new String[N][N];

        for(int i=0; i<N; i++)
            tempMap[i] = map[i].clone();

        for(int i=0; i<teacherList.size(); i++) {
            Point now = teacherList.get(i);

            for(int d=0; d<4; d++) {
                int nowR = now.r;
                int nowC = now.c;

                while(true) {
                    int nextR = nowR + dr[d];
                    int nextC = nowC + dc[d];

                    if(outofmapCheck(nextR, nextC))
                        break;

                    if(obstacleCheck(nextR, nextC, tempMap))
                        break;

                    if(studentCheck(nextR, nextC, tempMap)) {
                        return;
                    }

                    tempMap[nextR][nextC] = "T";
                    nowR = nextR;
                    nowC = nextC;
                }
            }
        }

        answer = true;
    }

    public static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    public static boolean obstacleCheck(int r, int c, String[][] tempMap) {
        return tempMap[r][c].equals("O");
    }

    public static boolean studentCheck(int r, int c, String[][] tempMap) {
        return tempMap[r][c].equals("S");
    }

    public static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
