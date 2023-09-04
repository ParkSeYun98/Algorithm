package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_13335_트럭 {

    private static int n;
    private static int w;
    private static int L;

    private static Queue<Integer> waitingQueue = new LinkedList<>();
    private static Queue<Integer> onBridgeQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++)
            waitingQueue.offer(Integer.parseInt(st.nextToken()));

        calc();
    }

    public static void calc() {
        int t = 0;
        int nowWeight = 0;

        while(true) {
            if(waitingQueue.size() == 0 && nowWeight == 0)
                break;

            int nextTruck = 0;

            if(waitingQueue.peek() != null)
                nextTruck = waitingQueue.peek();

            if(onBridgeQueue.size() == w) {
                nowWeight -= onBridgeQueue.peek();
                onBridgeQueue.poll();

                if(nowWeight + nextTruck <= L) {
                    onBridgeQueue.offer(nextTruck);
                    nowWeight += nextTruck;
                    waitingQueue.poll();
                }
                else
                    onBridgeQueue.offer(0);

            } else {
                if(nowWeight + nextTruck <= L) {
                    onBridgeQueue.offer(waitingQueue.peek());
                    nowWeight += nextTruck;
                    waitingQueue.poll();
                }
                else
                    onBridgeQueue.offer(0);
            }

            t++;
        }

        System.out.println(t);
    }
}
