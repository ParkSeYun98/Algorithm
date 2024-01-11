/*
* Memory : 20644 KB
* Time : 84 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_2251_물통 {

    private static int A;
    private static int B;
    private static int C;

    private static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        result = new ArrayList<>();

        BFS();

        Collections.sort(result);

        for (Integer i : result)
            System.out.print(i + " ");
    }

    public static void BFS() {
        Queue<Bottle> queue = new LinkedList<>();
        queue.offer(new Bottle(0, 0, C));

        boolean[][][] visited = new boolean[A+1][B+1][C+1];

        while(!queue.isEmpty()) {
            Bottle now = queue.poll();

            if(visited[now.a][now.b][now.c])
                continue;

            if(now.a == 0)
                result.add(now.c);

            visited[now.a][now.b][now.c] = true;

            // B -> A
            if(now.a + now.b <= A)
                queue.offer(new Bottle(now.a+now.b, 0, now.c));
            else
                queue.offer(new Bottle(A, now.a+now.b-A, now.c));

            // C -> A
            if(now.a + now.c <= A)
                queue.offer(new Bottle(now.a+now.c, now.b, 0));
            else
                queue.offer(new Bottle(A, now.b, now.a+now.c-A));

            // A -> B
            if(now.a + now.b <= B)
                queue.offer(new Bottle(0, now.a+now.b, now.c));
            else
                queue.offer(new Bottle(now.a+now.b-B, B, now.c));

            // C -> B
            if(now.b + now.c <= B)
                queue.offer(new Bottle(now.a, now.b+now.c, 0));
            else
                queue.offer(new Bottle(now.a, B, now.b+now.c-B));

            // A -> C
            if(now.a + now.c <= C)
                queue.offer(new Bottle(0, now.b, now.a+now.c));
            else
                queue.offer(new Bottle(now.a+now.c-C, now.b, C));

            // B -> C
            if(now.b + now.c <= C)
                queue.offer(new Bottle(now.a, 0, now.b+now.c));
            else
                queue.offer(new Bottle(now.a, now.b+now.c-C, C));
        }
    }

    public static class Bottle {
        int a;
        int b;
        int c;

        public Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
