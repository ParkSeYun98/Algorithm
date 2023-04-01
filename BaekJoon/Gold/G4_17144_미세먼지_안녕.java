package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_17144_미세먼지_안녕 {
    private static int R;
    private static int C;
    private static int T;

    // 우 상 좌 하
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};
    private static Point[] airPurifier;

    private static int[][] house;

    private static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int idx = 0;
        airPurifier = new Point[2];
        house = new int[R][C];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<C; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());

                if(house[i][j] == -1)
                    airPurifier[idx++] = new Point(i, j, -1);
            }
        }

        Process();

        Print();
    }

    public static void Process() {
        int t = 0;

        while(true) {
            if(t == T) {
                break;
            }

            spreadReady();

            spread();

            purify();

            t++;
        }
    }

    public static void spreadReady() {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(house[i][j] > 0)
                    queue.offer(new Point(i, j, house[i][j]));
            }
        }
    }

    public static void spread() {
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            int spreadAmount = 0;
            // 먼지 계산 시 한번에 할때 안꼬이기 위해 각 객체에 먼지값을 저장한 것을 이용해야 함.
            int partSpreadAmount = now.amount / 5;

            for(int d=0; d<4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(airPurifierCheck(nextX, nextY))
                    continue;

                house[nextX][nextY] += partSpreadAmount;
                spreadAmount += partSpreadAmount;
            }

            house[now.x][now.y] -= spreadAmount;
        }
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=R || y>=C;
    }

    public static boolean airPurifierCheck(int x, int y) {
        return house[x][y] == -1;
    }

    public static void purify() {
        int[][] copyArr = new int[R][C];

        for(int i=0; i<R; i++)
            copyArr[i] = house[i].clone();

        // 반시계방향
        // 오른쪽 방향으로
        for(int i=1; i<C; i++)
            house[airPurifier[0].x][i] = copyArr[airPurifier[0].x][i - 1];

        // 위쪽 방향으로
        for(int i=airPurifier[0].x-1; i>=0; i--)
            house[i][C-1] = copyArr[i+1][C-1];

        // 좌측 방향으로
        for(int i=C-2; i>=0; i--)
            house[0][i] = copyArr[0][i+1];

        // 아래쪽 방향으로
        for(int i=1; i<=airPurifier[0].x; i++)
            house[i][0] = copyArr[i-1][0];

        // 공기 청정기 위치 재조정
        house[airPurifier[0].x][1] = 0;
        house[airPurifier[0].x][airPurifier[0].y] = -1;

        // 시계방향
        // 오른쪽 방향으로
        for(int i=1; i<C; i++)
            house[airPurifier[1].x][i] = copyArr[airPurifier[1].x][i-1];
    
        // 아래쪽 방향으로
        for(int i=airPurifier[1].x+1; i<=R-1; i++)
            house[i][C-1] = copyArr[i-1][C-1];

        // 좌측 방향으로
        for(int i=C-2; i>=0; i--)
            house[R-1][i] = copyArr[R-1][i+1];

        // 위쪽 방향으로
        for(int i=R-2; i>=airPurifier[1].x; i--)
            house[i][0] = copyArr[i+1][0];

        // 공기 청정기 위치 재조정
        house[airPurifier[1].x][1] = 0;
        house[airPurifier[1].x][airPurifier[1].y] = -1;
    }

    public static void Print() {
        int sum = 0;

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++)
                sum += house[i][j];
        }

        System.out.println(sum+2);
    }

    public static class Point {
        int x;
        int y;
        int amount;

        public Point(int x, int y, int amount) {
            this.x = x;
            this.y = y;
            this.amount = amount;
        }
    }
}
