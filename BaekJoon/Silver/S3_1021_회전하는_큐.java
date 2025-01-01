package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S3_1021_회전하는_큐 {

    static int N, M, result;

    static int[] num;

    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = 0;
        num = new int[M];
        deque = new ArrayDeque<>();

        for(int i=1; i<=N; i++)
            deque.add(i);

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<M; i++)
            num[i] = Integer.parseInt(st.nextToken());

        func();
    }

    static void func() {
        for(int i=0; i<M; i++) {

            while(true) {
                int target = num[i];
                int size = deque.size();
                int halfIdx = -1;
                int targetIdx = -1;
                int nowIdx = 0;

                if(size%2 == 0)
                    halfIdx = size/2 - 1;
                else
                    halfIdx = size/2;

                for (Integer now : deque) {
                    if(now == target) {
                        targetIdx = nowIdx;
                        break;
                    }

                    nowIdx++;
                }

                if(deque.getFirst() == target) {
                    func1();
                    break;
                }
                else if(targetIdx <= halfIdx)
                    func2();
                else
                    func3();
            }
        }

        System.out.println(result);
    }

    static void func1() {
        deque.removeFirst();
    }

    static void func2() {
        deque.addLast(deque.removeFirst());
        result++;
    }

    static void func3() {
        deque.addFirst(deque.removeLast());
        result++;
    }
}
