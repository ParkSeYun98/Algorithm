package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_18258_큐_2 {
    static int front = -1;
    static int rear = -1;

    static int[] arr = new int[2_000_000];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String order = st.nextToken();

            switch(order) {
                case "push":
                    int pushTarget = Integer.parseInt(st.nextToken());
                    push(pushTarget);
                    break;
                case "pop" :
                    pop();
                    break;
                case "size" :
                    size();
                    break;
                case "empty" :
                    empty();
                    break;
                case "front" :
                    front();
                    break;
                case "back" :
                    back();
                    break;
            }
        }

        System.out.println(sb);
    }

    static void push(int target) {
        arr[++rear] = target;
    }

    static void pop() {
        if(rear == front)
            sb.append(-1).append('\n');
        else
            sb.append(arr[++front]).append('\n');
    }

    static void size() {
        sb.append(rear-front).append('\n');
    }

    static void empty() {
        if(rear == front)
            sb.append(1).append('\n');
        else
            sb.append(0).append('\n');
    }

    static void front() {
        if(rear == front)
            sb.append(-1).append('\n');
        else
            sb.append(arr[front+1]).append('\n');
    }

    static void back() {
        if(rear == front)
            sb.append(-1).append('\n');
        else
            sb.append(arr[rear]).append('\n');
    }
}
