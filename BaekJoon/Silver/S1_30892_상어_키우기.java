package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_30892_상어_키우기 {

    static int N, K, T;

    static Integer[] sharkArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        sharkArr = new Integer[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            sharkArr[i] = Integer.parseInt(st.nextToken());

        long size = T;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        Arrays.sort(sharkArr);

        for (Integer shark : sharkArr) {
            if(shark < size)
                stack.push(shark);
            else
                queue.offer(shark);
        }

        int cnt = 0;

        while(true) {
            if(cnt == K || stack.empty())
                break;

            size += stack.pop();

            while(true) {
                if(!queue.isEmpty() && queue.peek() < size)
                    stack.push(queue.poll());
                else
                    break;
            }

            cnt++;
        }

        System.out.println(size);
    }
}
