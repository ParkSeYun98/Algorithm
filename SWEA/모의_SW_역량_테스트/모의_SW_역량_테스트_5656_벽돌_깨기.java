package SWEA.모의_SW_역량_테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 모의_SW_역량_테스트_5656_벽돌_깨기 {
    private static int N;
    private static int W;
    private static int H;
    private static int min;

    private static int[] place;
    private static final int[] dr = {0, 0, 1, -1};
    private static final int[] dc = {1, -1, 0, 0};

    private static int[][] brick;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            brick = new int[H][W];

            for(int i=0; i<H; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<W; j++)
                    brick[i][j] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;
            place = new int[N];

            Permutation(0);

            System.out.println("#" + tc + " " + min);
        }
    }

    public static void Permutation(int depth) {
        if(depth == N) {
            int[][] copyArr = new int[H][W];
            for(int i=0; i<H; i++)
                copyArr[i] = brick[i].clone();

            Game();

            for(int i=0; i<H; i++)
                brick[i] = copyArr[i].clone();

            return;
        }

        for(int i=0; i<W; i++) {
            place[depth] = i;
            Permutation(depth + 1);
        }
    }

    public static void Game() {
        int turn = 0;

        while (turn < N) {

            Shoot(turn);

            Drop();

            turn++;
        }

        min = Math.min(min, getBrick());
    }

    public static void Shoot(int turn) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] check = new boolean[H][W];

        for(int i=0; i<H; i++) {
            if(brickCheck(i, place[turn])) {
                queue.offer(new Point(i, place[turn], brick[i][place[turn]]));
                check[i][place[turn]] = true;
                break;
            }
        }

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                for(int power=1; power<=now.weight-1; power++) {
                    int nextR = now.r + dr[d]*power;
                    int nextC = now.c + dc[d]*power;

                    if(outofmapCheck(nextR, nextC))
                        break;

                    if(!brickCheck(nextR, nextC))
                        continue;

                    if(check[nextR][nextC])
                        continue;

                    queue.offer(new Point(nextR, nextC, brick[nextR][nextC]));
                    check[nextR][nextC] = true;
                }
            }
        }

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                if(check[i][j])
                    brick[i][j] = 0;
            }
        }
    }

    public static void Drop() {
        int dropCnt = 0;
        int temp = 0;

        while(true) {
            for(int i=H-1; i>0; i--) {
                for(int j=0; j<W; j++) {
                    if(brick[i][j] == 0 && brick[i-1][j] != 0) {
                        brick[i][j] = brick[i-1][j];
                        brick[i-1][j] = 0;
                        dropCnt++;
                    }
                }
            }

            if(temp == dropCnt)
                break;

            temp = dropCnt;
        }
    }

    public static int getBrick() {
        int brickCnt = 0;

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                if(brick[i][j] != 0)
                    brickCnt++;
            }
        }

        return brickCnt;
    }

    public static boolean brickCheck(int r, int c) {
        return brick[r][c] != 0;
    }

    public static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=H || c>=W;
    }

    public static class Point {
        int r;
        int c;
        int weight;

        public Point(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }
    }
}
