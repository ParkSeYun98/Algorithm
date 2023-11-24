/*
* Memory : 293472 KB
* Time : 616 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_20301_반전_요세푸스 {

    private static int N;
    private static int K;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        reverseJosephus();
    }

    public static void reverseJosephus() {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++)
            deque.add(i);

        int cnt = 0;

        // false : 시계방향
        boolean direction = false;

        while(!deque.isEmpty()) {
            cnt++;

            if(!direction) {
                int now = deque.removeFirst();

                if(cnt != K)
                    deque.addLast(now);
                else {
                    cnt = 0;
                    list.add(now);

                    if(list.size() % M == 0)
                        direction = true;
                }
            }
            else {
                int now = deque.removeLast();

                if(cnt != K)
                    deque.addFirst(now);
                else {
                    cnt = 0;
                    list.add(now);

                    if(list.size() % M == 0)
                        direction = false;
                }
            }
        }

        for (Integer i : list)
            System.out.println(i);

    }
}
