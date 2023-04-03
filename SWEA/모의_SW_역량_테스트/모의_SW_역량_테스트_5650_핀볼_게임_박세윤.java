package SWEA.모의_SW_역량_테스트;

import java.io.IOException;
import java.util.Scanner;

public class 모의_SW_역량_테스트_5650_핀볼_게임_박세윤 {
    private static int N;
    private static int sR;
    private static int sC;
    private static int max;
    private static int score;

    // 상 우 하 좌
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt();

            map = new int[N][N];

            for(int i=0; i<N; i++)
                for(int j=0; j<N; j++)
                    map[i][j] = sc.nextInt();

            max = Integer.MIN_VALUE;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j] == 0) {
                        for(int dir = 0; dir<4; dir++) {
                            sR = i;
                            sC = j;
                            score = 0;
                            Game(i, j, dir);
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    public static void Game(int r, int c, int dir) {
        int startR = r;
        int startC = c;
        int startDir = dir;

        while(true) {
            int nextR = startR + dr[startDir];
            int nextC = startC + dc[startDir];

            if(outofmapCheck(nextR, nextC)) {
                score++;

                startR = nextR;
                startC = nextC;
                startDir = (startDir+2)%4;

                continue;
            }

            if(blackHoleCheck(nextR, nextC)) {
                max = Math.max(max, score);
                return;
            }

            if(comeBackHomeCheck(nextR, nextC)) {
                max = Math.max(max, score);
                return;
            }

            if(RectangularCheck(nextR, nextC)) {
                score++;

                startR = nextR;
                startC = nextC;
                startDir = (startDir+2)%4;

                continue;
            }

            if(TriangleCheck(nextR, nextC)) {
                score++;
                int nextDir = getTriangleDir(map[nextR][nextC], startDir);

                startR = nextR;
                startC = nextC;
                startDir = nextDir;

                continue;
            }

            if(wormHoleCheck(nextR, nextC)) {
                int endwormHoleR = -1;
                int endwormHoleC = -1;

                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        if(i == nextR && j == nextC)
                            continue;

                        if(map[i][j] == map[nextR][nextC]) {
                            endwormHoleR = i;
                            endwormHoleC = j;
                            break;
                        }
                    }
                }

                startR = endwormHoleR;
                startC = endwormHoleC;

                continue;
            }

            startR = nextR;
            startC = nextC;
        }
    }

    public static int getTriangleDir(int triangleType, int nowDir) {
        if(triangleType == 1) {
            if(nowDir == 2 || nowDir == 3)
                return 3-nowDir;
            else
                return (nowDir+2)%4;
        }
        else if(triangleType == 2) {
            if(nowDir == 0 || nowDir == 3)
                return Math.abs(nowDir - 1);
            else
                return (nowDir+2)%4;
        }
        else if(triangleType == 3) {
            if(nowDir == 1 || nowDir == 0)
                return 3-nowDir;
            else
                return (nowDir+2)%4;
        }
        else {
            if(nowDir == 1 || nowDir == 2)
                return (5-nowDir)%4;
            else
                return (nowDir+2)%4;
        }
    }

    public static boolean blackHoleCheck(int r, int c) {
        return map[r][c] == -1;
    }

    public static boolean comeBackHomeCheck(int r, int c) {
        return r == sR && c == sC;
    }

    public static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    public static boolean RectangularCheck(int r, int c) {
        return map[r][c] == 5;
    }

    public static boolean TriangleCheck(int r, int c) {
        return map[r][c] >= 1 && map[r][c] <= 4;
    }

    public static boolean wormHoleCheck(int r, int c) {
        return map[r][c] >= 6;
    }
}