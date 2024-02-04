/*
* Memory : 11964 KB
* Time : 88 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class S3_12789_도키도키_간식드리미 {

    static int N;

    static Queue<Integer> studentQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        studentQueue = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            studentQueue.offer(Integer.parseInt(st.nextToken()));

        rearrange();
    }

    static void rearrange() {
        Stack<Integer> studentStack = new Stack<>();

        int idx = 1;

        while(true) {
            if(idx == N+1) {
                System.out.println("Nice");
                break;
            }

            int temp = -1;

            if(!studentQueue.isEmpty())
                temp = studentQueue.peek();

            if(idx == temp) {
                idx++;
                studentQueue.poll();
                continue;
            }
            else {
                if(!studentStack.isEmpty() && studentStack.peek() == idx) {
                    studentStack.pop();
                    idx++;
                    continue;
                }

                if(temp != -1) {
                    studentQueue.poll();
                    studentStack.push(temp);
                    continue;
                }

                System.out.println("Sad");
                break;
            }
        }
    }
}
