package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2343_기타_레슨 {
    private static int N;
    private static int M;
    private static int[] blueray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        blueray = new int[N];
        int left = Integer.MIN_VALUE;
        int right = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            blueray[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, blueray[i]);
            right += blueray[i];
        }

        binarySearch(left, right);
    }

    public static void binarySearch(int left, int right) {
        while(left <= right) {
            int mid = (left + right) / 2;

            int cnt = getBlueraySize(mid);

            if(cnt > M)
                left = mid + 1;
            else
                right = mid - 1;
        }

        System.out.println(left);
    }

    public static int getBlueraySize(int mid) {
        int partSum = 0;
        int cnt = 0;

        for(int i=0; i<N; i++) {
            if(partSum + blueray[i] > mid) {
                partSum = 0;
                cnt++;
            }
            partSum += blueray[i];
        }

        return cnt+1;
    }
}
