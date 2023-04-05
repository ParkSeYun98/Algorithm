package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G3_15685_드래곤_커브 {
    private static final int RIGHT = 0;
    private static final int UP = 1;
    private static final int LEFT = 2;
    private static final int DOWN = 3;

    private static int N;

    private static int[][] map;

    private static List<Integer> dirList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[101][101];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dirList = new ArrayList<>();
            dirList.add(d);

            getDirection(g);

            drawPoint(x, y);
        }

        System.out.println(checkRectangular());
    }

    public static void getDirection(int generation) {
        int nowGeneration = 0;

        while(true) {
            if(nowGeneration == generation)
                break;

            for(int i=dirList.size()-1; i>=0; i--)
                dirList.add((dirList.get(i) + 1) % 4);

            nowGeneration++;
        }
    }

    public static void drawPoint(int startX, int startY) {
        int x = startX;
        int y = startY;

        map[x][y] = 1;

        for (int dir : dirList) {
            if (dir == RIGHT)
                map[++x][y] = 1;
            else if (dir == UP)
                map[x][--y] = 1;
            else if (dir == LEFT)
                map[--x][y] = 1;
            else if (dir == DOWN)
                map[x][++y] = 1;
        }
    }

    public static int checkRectangular() {
        int cnt = 0;

        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1)
                    cnt++;
            }
        }

        return cnt;
    }
}
