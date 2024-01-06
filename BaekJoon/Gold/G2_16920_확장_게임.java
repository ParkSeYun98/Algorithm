/*
* Memory : 68012 KB
* Time : 496 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G2_16920_확장_게임 {

    private static int N;
    private static int M;
    private static int P;

    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};
    private static int[] ability;

    private static char[][] map;

    private static Queue<Point>[] queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        ability = new int[P+1];
        map = new char[N][M];

        queue = new LinkedList[P+1];
        for(int i=0; i<queue.length; i++)
            queue[i] = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<P; i++)
            ability[i+1] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            String temp = br.readLine();

            for(int j=0; j<temp.length(); j++) {
                char temp2 = temp.charAt(j);
                map[i][j] = temp2;

                if(temp2 != '.' && temp2 != '#') {
                    int player = temp2 - '0';

                    queue[player].offer(new Point(i, j));
                }
            }
        }

        BFS();

        int[] cntArr = new int[P+1];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != '.' && map[i][j] != '#')
                    cntArr[map[i][j] - '0']++;
            }
        }

        for(int i=1; i<cntArr.length; i++)
            System.out.print(cntArr[i] + " ");

//        for(int i=0; i<N; i++) {
//            for(int j=0; j<M; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static void BFS() {
        int player = 1;
        boolean flag = false;

        while(true) {
            if(player == P+1) {
                if(!flag)
                    break;

                player = 1;
                flag = false;
            }

            int distance = 0;
            boolean partFlag = false;

            while(!queue[player].isEmpty()) {
                int size = queue[player].size();

                for(int i=0; i<size; i++) {
                    Point now = queue[player].poll();

                    for(int d=0; d<4; d++) {
                        int nextR = now.r + dr[d];
                        int nextC = now.c + dc[d];

                        if(outOfMapCheck(nextR, nextC))
                            continue;

                        if(!extensionCheck(nextR,nextC))
                            continue;

                        map[nextR][nextC] = map[now.r][now.c];
                        queue[player].offer(new Point(nextR, nextC));
                        partFlag = true;
                    }
                }

                distance++;

                if(partFlag)
                    flag = true;

                if(distance >= ability[player])
                    break;
            }

            player++;
        }
    }

    public static boolean outOfMapCheck(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= M;
    }

    public static boolean extensionCheck(int r, int c) {
        return map[r][c] == '.';
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
