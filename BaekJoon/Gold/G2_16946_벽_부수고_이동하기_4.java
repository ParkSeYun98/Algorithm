/*
* Memory : 249040 KB
* Time : 916 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_16946_벽_부수고_이동하기_4 {

    static int N, M;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] map, groupArr;

    static Map<Integer, Integer> groupMap;

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        groupArr = new int[N][M];
        groupMap = new HashMap<>();

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++) {
                int tmp = input.charAt(j) - 48;

                map[i][j] = tmp;
            }
        }

        int idx = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0 && groupArr[i][j] == 0)
                    BFS(new Point(i, j), ++idx);
            }
        }

        setting();
    }

    static void BFS(Point start, int idx) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        groupArr[start.r][start.c] = idx;

        int cnt = 0;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            cnt++;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(wallCheck(nextR, nextC))
                    continue;

                if(groupCheck(nextR, nextC))
                    continue;

                queue.offer(new Point(nextR, nextC));
                groupArr[nextR][nextC] = idx;
            }
        }

        groupMap.put(idx, cnt);
    }

    static void setting() {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                int sum = 1;
                Set<Integer> set = new HashSet<>();

                if(map[i][j] == 1) {
                    for(int d=0; d<4; d++) {
                        int nextR = i + dr[d];
                        int nextC = j + dc[d];

                        if(outOfMapCheck(nextR, nextC))
                            continue;

                        if(groupArr[nextR][nextC] == 0)
                            continue;

                        if(emptyCheck(nextR, nextC))
                            set.add(groupArr[nextR][nextC]);
                    }
                }

                for (Integer groupNum : set)
                    sum += groupMap.get(groupNum);

                if(map[i][j] == 0)
                    sb.append(0);
                else
                    sb.append(sum%10);
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }

    static boolean wallCheck(int r, int c) {
        return map[r][c] == 1;
    }

    static boolean emptyCheck(int r, int c) {
        return map[r][c] == 0;
    }

    static boolean groupCheck(int r, int c) {
        return groupArr[r][c] != 0;
    }
}
