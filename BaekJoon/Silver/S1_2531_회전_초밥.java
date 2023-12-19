/*
Memory : 16312 KB
Time : 132 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2531_회전_초밥 {

    private static int N;
    private static int d;
    private static int k;
    private static int c;

    private static int[] belt;
    private static int[] eatenSushi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(),  " ");
        N = Integer.parseInt(st.nextToken()); // 벨트에 놓인 접시 수
        d = Integer.parseInt(st.nextToken()); // 초밥 가짓 수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        belt = new int[N];

        for(int i=0; i<N; i++)
            belt[i] = Integer.parseInt(br.readLine());

        eatenSushi = new int[d+1];

        event();
    }

    public static void event() {
        int cnt = 0;
        int left = 0;
        int right = 0;

        // 최초 0번 ~ k-1번 까지 먹는다는 가정 하의 초기화.
        for(int i=0; i<k; i++) {
            ++eatenSushi[belt[right]];

            if(eatenSushi[belt[right]] == 1)
                ++cnt;
            ++right;
        }

        int max = cnt;

        while(left != N) {
            // 시작점
            --eatenSushi[belt[left]];

            if(eatenSushi[belt[left]] == 0)
                --cnt;
            ++left;

            // 끝점
            ++eatenSushi[belt[right]];

            if(eatenSushi[belt[right]] == 1)
                ++cnt;
            ++right;

            // 회전
            if(right == N)
                right = 0;

            // 쿠폰
            if(eatenSushi[c] == 0)
                max = Math.max(max, cnt+1);
            else
                max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
