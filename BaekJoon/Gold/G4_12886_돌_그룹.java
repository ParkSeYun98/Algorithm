/*
* Memory : 44624 KB
* Time : 160 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_12886_돌_그룹 {

    static int A, B, C;

    static boolean[][] visited;

    static Queue<Stone> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        BFS();
    }

    static void BFS() {
        queue = new LinkedList<>();
        queue.offer(new Stone(A, B, C));

        visited = new boolean[1501][1501];
        visited[A][B] = true;

        while(!queue.isEmpty()) {
            Stone now = queue.poll();

            if(now.a==now.b && now.b==now.c) {
                System.out.println(1);
                return;
            }

            check(now.a, now.b, now.c);
        }

        System.out.println(0);
    }

    static void check(int tempA, int tempB, int tempC) {
        if(tempA != tempB) {
            int nextA = tempA>tempB ? tempA-tempB : tempA+tempA;
            int nextB = tempA>tempB ? tempB+tempB : tempB-tempA;

            if(!visited[nextA][nextB]) {
                queue.offer(new Stone(nextA, nextB, tempC));
                visited[nextA][nextB] = true;
            }
        }

        if(tempB != tempC) {
            int nextB = tempB>tempC ? tempB-tempC : tempB+tempB;
            int nextC = tempB>tempC ? tempC+tempC : tempC-tempB;

            if(!visited[nextB][nextC]) {
                queue.offer(new Stone(tempA, nextB, nextC));
                visited[nextB][nextC] = true;
            }
        }

        if(tempC != tempA) {
            int nextC = tempC>tempA ? tempC-tempA : tempC+tempC;
            int nextA = tempC>tempA ? tempA+tempA : tempA-tempC;

            if(!visited[nextC][nextA]) {
                queue.offer(new Stone(nextC, tempB, nextA));
                visited[nextC][nextA] = true;
            }
        }
    }

    static class Stone {
        int a, b, c;

        public Stone(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
