package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_12851_숨바꼭질_2 {

    static int N, K, min, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N >= K) {
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        cnt = 0;
        min = Integer.MAX_VALUE;

        BFS();

        System.out.println(min);
        System.out.println(cnt);
    }

    static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        int[] time = new int[100001];
        time[N] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(time[now] > min)
                return;

            if(now == K) {
                cnt++;
                min = time[now];
            }

            for(int i=0; i<3; i++) {
                int next = 0;

                if(i == 0)
                    next = now + 1;
                else if(i == 1)
                    next = now - 1;
                else
                    next = 2 * now;

                if(outOfRange(next))
                    continue;

                if(visitCheck(next, now, time))
                    continue;

                queue.offer(next);
                time[next] = time[now] + 1;
            }
        }
    }

    static boolean outOfRange(int next) {
        return next < 0 || next > 100000;
    }

    static boolean visitCheck(int next, int now, int[] time) {
        return (time[next] != 0) && (time[next] != time[now] + 1);
    }
}
