package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_2512_예산 {

    private static int N;
    private static int M;

    private static int[] budget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        budget = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            budget[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        Arrays.sort(budget);

        System.out.println(binarySearch());
    }

    public static int binarySearch() {
        int low = 0;
        int high = budget[budget.length - 1];

        while(true) {
            int mid = (low + high) / 2;

            if(low > high)
                return high;

            int cnt = 0;

            for(int i=0; i<budget.length; i++) {
                if(mid > budget[i])
                    cnt += budget[i];
                else
                    cnt += mid;
            }

            if(cnt > M)
                high = mid - 1;
            else
                low = mid + 1;
        }
    }
}
