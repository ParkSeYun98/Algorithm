package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2_10811_바구니_뒤집기 {

    private static Queue<Integer> queue;
    private static Queue<Integer> subQueue;
    private static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        subQueue = new LinkedList<>();
        stack  = new Stack<>();

        for(int i=0; i<N; i++)
            queue.offer(i+1);

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            changeDirection(start, end, queue);
        }

        for (Integer i : queue)
            System.out.print(i + " ");
    }

    public static void changeDirection(int start, int end, Queue<Integer> queue) {
        int size = queue.size();

        for(int i=0; i<size; i++) {
            int now = queue.poll();
            int idx = i + 1;

            if(idx < start)
                queue.offer(now);
            else if(idx <= end)
                stack.push(now);
            else
                subQueue.offer(now);
        }

        while(!stack.isEmpty())
            queue.offer(stack.pop());

        while(!subQueue.isEmpty())
            queue.offer(subQueue.poll());
    }
}
