package SWEA.모의_SW_역량_테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 모의_SW_역량_테스트_5644_무선_충전_박세윤 {
    private static int M;
    private static int A;
    private static int charge;

    private static int[] X;
    private static int[] Y;
    private static int[] C;
    private static int[] P;
    private static int[] moveA;
    private static int[] moveB;

    // 0 : 이동 X, 1 : up, 2 : right, 3 : down, 4 : left
    private static final int[] dx = {0, -1, 0, 1, 0};
    private static final int[] dy = {0, 0, 1, 0, -1};

    private static List<Integer>[][] BC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            moveA = new int[M];
            moveB = new int[M];

            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++)
                moveA[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++)
                moveB[j] = Integer.parseInt(st.nextToken());

            X = new int[A+1];
            Y = new int[A+1];
            C = new int[A+1];
            P = new int[A+1];

            BC = new ArrayList[11][11];

            for(int i=1; i<=10; i++) {
                for(int j=1; j<=10; j++)
                    BC[i][j] = new ArrayList<>();
            }

            for(int i=1; i<=A; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                Y[i] = Integer.parseInt(st.nextToken());
                X[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
                P[i] = Integer.parseInt(st.nextToken());

                spread(X[i], Y[i], C[i], i);
            }

            charge = 0;

            move();

            System.out.println("#" + tc + " " + charge);
        }
    }

    public static void spread(int x, int y, int c, int idx) {
        Queue<Point> queue = new LinkedList<>();
        Point startP = new Point(x, y);
        queue.offer(startP);

        BC[x][y].add(idx);

        boolean[][] visited = new boolean[11][11];
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=1; d<=4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(!rangeCheck(nextX, nextY, x, y, c))
                    continue;

                if(visited[nextX][nextY])
                    continue;

                queue.offer(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
                BC[nextX][nextY].add(idx);
            }
        }
    }

    public static void move() {
        int turn = 0;
        Point AP = new Point(1, 1);
        Point BP = new Point(10, 10);

        while(turn <= M) {
            charge += comparison(BC[AP.x][AP.y], BC[BP.x][BP.y], turn);

            if(turn == M)
                break;

            int dirA = moveA[turn];
            int dirB = moveB[turn];

            int AnextX = AP.x + dx[dirA];
            int AnextY = AP.y + dy[dirA];
            int BnextX = BP.x + dx[dirB];
            int BnextY = BP.y + dy[dirB];

            AP = new Point(AnextX, AnextY);
            BP = new Point(BnextX, BnextY);

            turn++;
        }
    }

    public static int comparison(List<Integer> listA, List<Integer> listB, int turn) {
        int max = 0;

        int[] temp = new int[2];

        if(listA.size() >= 1 && listB.size() >= 1) {
            for(int i=0; i<listA.size(); i++) {
                temp[0] = listA.get(i);

                for(int j=0; j<listB.size(); j++) {
                    temp[1] = listB.get(j);

                    int partSum = 0;

                    if(temp[0] == temp[1]) {
                        partSum = P[temp[0]];
                    } else
                        partSum = P[temp[0]] + P[temp[1]];

                    max = Math.max(partSum, max);
                }
            }
        }
        else if(listA.size() == 0 && listB.size() >= 1) {
            for(int i=0; i<listB.size(); i++)
                max = Math.max(P[listB.get(i)], max);
        }
        else if(listA.size() >= 1 && listB.size() == 0) {
            for(int i=0; i<listA.size(); i++)
                max = Math.max(P[listA.get(i)], max);
        }
        else
            max = 0;

        return max;
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<1 || y<1 || x>=11 || y>=11;
    }

    public static boolean rangeCheck(int targetX, int targetY, int startX, int startY, int c) {
        int disttoTarget = Math.abs(targetX - startX) + Math.abs(targetY - startY);

        return disttoTarget <= c;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
