package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S1_19638_센티와_마법의_뿅망치 {

    static int N, H, T;

    static int[] giant;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<N; i++)
            pq.add(Integer.parseInt(br.readLine()));

        int cnt = 0;

        while(T>0 && !pq.isEmpty()) {
            int now = pq.peek();

            if(now<H || now==1)
                break;

            cnt++;
            T--;
            pq.add(pq.poll()/2);
        }

        int max = pq.peek();

        if(max < H) {
            System.out.println("YES");
            System.out.println(cnt);
        }
        else {
            System.out.println("NO");
            System.out.println(max);
        }
    }
}
