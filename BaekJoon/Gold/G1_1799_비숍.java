package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G1_1799_비숍 {
    static int N;
    static int blackMax = Integer.MIN_VALUE;
    static int whiteMax = Integer.MIN_VALUE;

    static boolean[] visited;

    static int[][] map;

    static List<Point> oneList;
    static List<Point> comb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        comb = new ArrayList<>();
        oneList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1)
                    oneList.add(new Point(i, j));
            }
        }

        visited = new boolean[oneList.size()];

        comb = new ArrayList<>();
        boolean flag = false;
        DFS(0, flag);

        comb = new ArrayList<>();
        flag = true;
        DFS(0, flag);

        System.out.println(whiteMax + blackMax);
    }

    static void DFS(int idx, boolean flag) {
        if(!flag)
            blackMax = Math.max(blackMax, comb.size());
        else
            whiteMax = Math.max(whiteMax, comb.size());

        for(int i=idx; i<oneList.size(); i++) {
            if(((oneList.get(i).r + oneList.get(i).c) % 2 == 0 && flag) || ((oneList.get(i).r + oneList.get(i).c) % 2 == 1 && !flag))
                continue;

            if(!visited[i] && Check(i)) {
                visited[i] = true;
                comb.add(oneList.get(i));
                DFS(i+1, flag);
                comb.remove(comb.size()-1);
                visited[i] = false;
            }
        }
    }

    static boolean Check(int idx) {
        for(int i=0; i<comb.size(); i++) {
            if(Math.abs(comb.get(i).r - oneList.get(idx).r) == Math.abs(comb.get(i).c - oneList.get(idx).c))
                return false;
        }

        return true;
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
