package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1711_직각삼각형 {

    static int N, cnt;

    static boolean[] visited;
    static Point[] pointArr, triangleArr;

    static class Point {
        long r;
        long c;

        public Point(long r, long c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cnt = 0;
        visited = new boolean[N];
        pointArr = new Point[N];
        triangleArr = new Point[3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            long r = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            pointArr[i] = new Point(r, c);
        }

        DFS(0, 0);

        System.out.println(cnt);
    }

    static void DFS(int depth, int start) {
        if(depth == 3) {
            if(angleCheck())
                cnt++;

            return;
        }

        for(int i=start; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                triangleArr[depth] = pointArr[i];
                DFS(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    static boolean angleCheck() {
        long r1 = triangleArr[0].r;
        long c1 = triangleArr[0].c;
        long r2 = triangleArr[1].r;
        long c2 = triangleArr[1].c;
        long r3 = triangleArr[2].r;
        long c3 = triangleArr[2].c;

        long A = (r1-r2)*(r1-r2) + (c1-c2)*(c1-c2);
        long B = (r2-r3)*(r2-r3) + (c2-c3)*(c2-c3);
        long C = (r3-r1)*(r3-r1) + (c3-c1)*(c3-c1);

        return (A + B == C) || (B + C == A) || (C + A == B);
    }
}
