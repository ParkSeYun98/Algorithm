package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2792_보석_상자 {

    static int N, M, left, right, ans;

    static int[] jewels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = 0;
        left = 1;
        jewels = new int[M];

        for(int i=0; i<M; i++) {
            int input = Integer.parseInt(br.readLine());
            jewels[i] = input;
            right = Math.max(right, input);
        }

        BinarySearch();
    }

    static void BinarySearch() {
        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for(int i=0; i<M; i++) {
                sum += jewels[i] / mid;

                if(jewels[i] % mid != 0)
                    sum++;
            }

            if(sum > N)
                left = mid + 1;
            else {
                right = mid - 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}
