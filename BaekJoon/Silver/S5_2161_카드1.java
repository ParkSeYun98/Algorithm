package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S5_2161_카드1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++)
            queue.offer(i);

        while(true) {
            if(queue.size() == 1)
                break;

            System.out.print(queue.remove() + " ");

            int next = queue.remove();
            queue.offer(next);
        }

        System.out.println(queue.peek());
    }
}
