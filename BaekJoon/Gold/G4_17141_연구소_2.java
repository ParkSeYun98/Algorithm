package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_17141_연구소_2 {

    private static int N;
    private static int M;
    private static int cnt;
    private static int result;

    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};
    private static boolean[] check;

    private static int[][] lab;

    private static List<Point> virusStartPointList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = 0;
        result = Integer.MAX_VALUE;
        lab = new int[N][N];
        virusStartPointList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                lab[i][j] = temp;

                if(temp == 2)
                    virusStartPointList.add(new Point(i, j));
                else if(temp == 0)
                    cnt++;
            }
        }

        cnt += (virusStartPointList.size() - M);
        check = new boolean[virusStartPointList.size()];

        if(cnt == 0) {
            System.out.println(0);
            return;
        }

        getVirusStartPoint(0, 0);

        if(result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    public static void getVirusStartPoint(int depth, int start) {
        if(depth == M) {
            int[][] copyLab = copy();
            Spread(copyLab);

            return;
        }

        for(int i=start; i<virusStartPointList.size(); i++) {
            check[i] = true;
            getVirusStartPoint(depth+1, i+1);
            check[i] = false;
        }
    }

    public static void Spread(int[][] copyLab) {
        Queue<Point> queue = new LinkedList<>();

        int count = cnt;

        for(int i=0; i<virusStartPointList.size(); i++) {
            if(check[i])
                queue.offer(virusStartPointList.get(i));
        }

        int t=0;

        while(!queue.isEmpty()) {
            int queueSize = queue.size();

            for(int i=0; i<queueSize; i++) {
                Point now = queue.poll();

                for(int d=0; d<4; d++) {
                    int nextR = now.r + dr[d];
                    int nextC = now.c + dc[d];

                    if(outOfMapCheck(nextR, nextC))
                        continue;

                    if(!spreadCheck(nextR, nextC, copyLab))
                        continue;

                    copyLab[nextR][nextC] = 2;
                    queue.offer(new Point(nextR, nextC));
                    count--;
                }
            }

            t++;

            if(count == 0) {
                result = Math.min(result, t);
                return;
            }
        }
    }

    public static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    public static boolean spreadCheck(int r, int c, int[][] copyLab) {
        return copyLab[r][c] == 0;
    }

    public static int[][] copy() {
        int[][] copyLab = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(lab[i][j] == 2)
                    copyLab[i][j] = 0;
                else
                    copyLab[i][j] = lab[i][j];
            }
        }

        for(int i=0; i<virusStartPointList.size(); i++) {
            if(check[i])
                copyLab[virusStartPointList.get(i).r][virusStartPointList.get(i).c] = 2;
        }

        return copyLab;
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
