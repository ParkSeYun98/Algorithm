/*
* Memory : 25060 KB
* Time : 376 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_1715_카드_정렬하기 {

    static int N;

    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>();

        for(int i=0; i<N; i++)
            pq.offer(Integer.parseInt(br.readLine()));

        solve();
    }

    static void solve() {
        int answer = 0;

        while(pq.size() > 1) {
            int A = pq.poll();
            int B = pq.poll();
            int C = A + B;

            answer += C;

            pq.offer(C);
        }

        System.out.println(answer);
    }
}
