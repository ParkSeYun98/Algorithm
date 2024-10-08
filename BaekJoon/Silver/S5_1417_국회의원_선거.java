package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class S5_1417_국회의원_선거 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int D = Integer.parseInt(br.readLine());

        for(int i=0; i<N-1; i++)
            pq.add(Integer.parseInt(br.readLine()));

        int cnt = 0;

        while(!pq.isEmpty()) {
            if(pq.peek() >= D) {
                pq.add(pq.poll()-1);
                D++;
                cnt++;
            }
            else
                break;
        }

        System.out.println(cnt);
    }
}
