package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G1_18809_Gaaaaaaaaaarden {
    static final int RED = 3;
    static final int GREEN = 4;
    static final int FLOWER = 5;

    static int N;
    static int M;
    static int G;
    static int R;
    static int max = Integer.MIN_VALUE;

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    static boolean[] visited;
    static int[] red;
    static int[] green;

    static int[][] garden;
    static boolean[][] BFSvisited;

    static List<Point> candidate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        garden = new int[N][M];
        candidate = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++) {
                garden[i][j] = Integer.parseInt(st.nextToken());

                if(garden[i][j] == 2)
                    candidate.add(new Point(i, j));
            }
        }

        visited = new boolean[candidate.size()];
        green = new int[G];
        red = new int[R];
        greenPermutation(0, 0);

        System.out.println(max);
    }

    static void greenPermutation(int depth, int idx) {
        if(depth == G) {
            redPermutation(0, 0);
            return;
        }

        for(int i=idx; i<candidate.size(); i++) {
            if(!visited[i]) {
                green[depth] = i;
                visited[i] = true;
                greenPermutation(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    static void redPermutation(int depth, int idx) {
        if(depth == R) {
            BFS();
            return;
        }

        for(int i=idx; i<candidate.size(); i++) {
            if(!visited[i]) {
                red[depth] = i;
                visited[i] = true;
                redPermutation(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        State[][] visited = new State[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++)
                visited[i][j] = new State(0, 0);
        }

        for(int i=0; i<R; i++) {
            queue.offer(new Point(candidate.get(red[i]).r, candidate.get(red[i]).c));
            visited[candidate.get(red[i]).r][candidate.get(red[i]).c] = new State(0, RED);
        }

        for(int i=0; i<G; i++) {
            queue.offer(new Point(candidate.get(green[i]).r, candidate.get(green[i]).c));
            visited[candidate.get(green[i]).r][candidate.get(green[i]).c] = new State(0, GREEN);
        }

        int cnt = 0;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(visited[now.r][now.c].state == FLOWER)
                continue;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outofmapCheck(nextR, nextC))
                    continue;

                if(lakeCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC].state == 0) {
                    queue.offer(new Point(nextR, nextC));
                    visited[nextR][nextC] = new State(visited[now.r][now.c].time+1, visited[now.r][now.c].state);
                }
                else if(visited[nextR][nextC].state == RED) {
                    if(visited[now.r][now.c].state == GREEN && visited[nextR][nextC].time == visited[now.r][now.c].time + 1) {
                        cnt++;
                        visited[nextR][nextC].state = FLOWER;
                    }
                }
                else if(visited[nextR][nextC].state == GREEN && visited[nextR][nextC].time == visited[now.r][now.c].time + 1) {
                    if(visited[now.r][now.c].state == RED) {
                        cnt++;
                        visited[nextR][nextC].state = FLOWER;
                    }
                }
            }
        }

        max = Math.max(max, cnt);
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }

    static boolean lakeCheck(int r, int c) {
        return garden[r][c] == 0;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class State {
        int time;
        int state;

        public State(int time, int state) {
            this.time = time;
            this.state = state;
        }
    }
}
