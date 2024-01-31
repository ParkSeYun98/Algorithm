/*
* Memory : 11532 KB
* Time : 84 ms
* */

package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_1173_운동 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 운동 시간
        int m = Integer.parseInt(st.nextToken()); // 최소 맥박, 기본 맥박
        int M = Integer.parseInt(st.nextToken()); // 최대 맥박
        int T = Integer.parseInt(st.nextToken()); // 운동 시 증가 맥박
        int R = Integer.parseInt(st.nextToken()); // 휴식 시 감소 맥박

        int now = m;
        int t = 0;

        if(m + T > M) {
            System.out.println(-1);
            return;
        }

        while(true) {
            if(N==0) {
                System.out.println(t);
                break;
            }

            t++;

            if(N>0 && now+T<=M) {
                N--;
                now += T;
                continue;
            }

            if(now-R>=m) {
                now -= R;
                continue;
            }
            else {
                now = m;
                continue;
            }
        }
    }
}
