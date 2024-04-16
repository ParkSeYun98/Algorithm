package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_12015_가장_긴_증가하는_부분_수열_2 {

    static int N;

    static int[] A, LIS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        LIS = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        LIS[0] = A[0];
        int length = 1;

        for(int i=1; i<N; i++) {
            int now = A[i];

            if(now > LIS[length - 1])
                LIS[++length - 1] = now;
            else {
                // 이분탐색으로 LIS 배열 중 교체하기 위한 위치를 찾는다.
                // 이해하기 어렵다면 https://st-lab.tistory.com/285 이 글을 잘 읽어보기

                int low = 0;
                int high = length;

                while(low < high) {
                    int mid = (low + high) / 2;

                    if(LIS[mid] < now)
                        low = mid + 1;
                    else
                        high = mid;
                }

                LIS[low] = now;
            }
        }

        System.out.println(length);
    }
}
