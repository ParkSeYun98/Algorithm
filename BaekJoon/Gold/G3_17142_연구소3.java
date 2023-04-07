package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_17142_연구소3 {
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    static boolean[] visited;
    static Point[] selectedVirus;

    static int[][] lab;

    static List<Point> virusList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selectedVirus = new Point[M];
        lab = new int[N][N];
        virusList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if(lab[i][j] == 2)
                    virusList.add(new Point(i, j));
            }
        }

        visited = new boolean[virusList.size()];

        Combination(0, 0);

        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void Combination(int depth, int idx) {
        if(depth == M) {
            int[][] labCopy = new int[N][N];
            for(int i=0; i<N; i++)
                labCopy[i] = lab[i].clone();

            BFS();

            for(int i=0; i<N; i++)
                lab[i] = labCopy[i].clone();

            return;
        }

        for(int i=idx; i<virusList.size(); i++) {
            if(!visited[i]) {
                selectedVirus[depth] = virusList.get(i);
                visited[i] = true;
                Combination(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        List<Point> tempList = new ArrayList<>();

        for (Point virus : selectedVirus) {
            lab[virus.r][virus.c] = 3;
            tempList.add(virus);
        }

        int time = 0;

        while(true) {
            if(allInfectionCheck()) {
                min = Math.min(min, time);
                return;
            }

            if(tempList.size() == 0)
                return;

            for(int i=tempList.size()-1; i>=0; i--) {
                queue.offer(tempList.get(i));
                tempList.remove(i);
            }

            while(!queue.isEmpty()) {
                Point now = queue.poll();

                for(int d=0; d<4; d++) {
                    int nextR = now.r + dr[d];
                    int nextC = now.c + dc[d];

                    if(outofmapCheck(nextR, nextC))
                        continue;

                    if(wallCheck(nextR, nextC))
                        continue;

                    if(alreadyInfectedCheck(nextR, nextC))
                        continue;

                    tempList.add(new Point(nextR, nextC));
                    lab[nextR][nextC] = 3;
                }
            }

            time++;
        }
    }

    static boolean allInfectionCheck() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(lab[i][j] == 0)
                    return false;
            }
        }

        return true;
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    static boolean wallCheck(int r, int c) {
        return lab[r][c] == 1;
    }

    static boolean alreadyInfectedCheck(int r, int c) {
        return lab[r][c] == 3;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
