package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S4_11866_요세푸스_문제_0 {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Josephus();
    }

    static void Josephus() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++)
            queue.offer(i);

        int cnt = 0;

        while(!queue.isEmpty()) {
            cnt++;

            int now = queue.poll();

            if(cnt%K != 0)
                queue.offer(now);
            else
                sb.append(now).append(", ");
        }

        sb.delete(sb.length()-2, sb.length());

        sb.append(">");

        System.out.println(sb);
    }
}
