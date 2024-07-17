package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class G5_22251_빌런_호석 {

    static int N, K, P, X, count;

    static String nowDisplay;

    static int[][] display = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 층 수
        K = Integer.parseInt(st.nextToken()); // 자리 수
        P = Integer.parseInt(st.nextToken()); // 최대 반전 개수
        X = Integer.parseInt(st.nextToken()); // 현재 층

        nowDisplay = changeX(X);

        reverse();

        System.out.println(count);
    }

    static void reverse() {
        count = 0;

        for(int i=1; i<=N; i++) {
            if(i == X)
                continue;

            String targetDisplay = changeX(i);
            int cnt = 0;
            boolean flag = true;

            outer : for(int j=0; j<K; j++) {
                for(int k=0; k<7; k++) {
                    if(display[nowDisplay.charAt(j) - '0'][k] != display[targetDisplay.charAt(j) - '0'][k]) {
                        cnt++;

                        if(cnt > P) {
                            flag = false;
                            break outer;
                        }
                    }
                }
            }

            if(flag)
                count++;
        }

    }

    static String changeX(int num) {
        Stack<Integer> stack = new Stack<>();
        String str = "";
        int cnt = 0;

        while(num > 0) {
            stack.push(num % 10);
            num /= 10;
            cnt++;
        }

        for(int i=0; i<K-cnt; i++)
            str += "0";

        while(!stack.isEmpty())
            str += stack.pop();

        return str;
    }
}
