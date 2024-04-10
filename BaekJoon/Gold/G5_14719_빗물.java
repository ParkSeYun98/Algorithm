package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_14719_빗물 {

    static int H, W, max, maxIdx;

    static int[] block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        maxIdx = -1;
        max = Integer.MIN_VALUE;
        block = new int[W];

        st = new StringTokenizer(br.readLine() , " ");

        for(int i=0; i<W; i++) {
            block[i] = Integer.parseInt(st.nextToken());

            if(max < block[i]) {
                max = block[i];
                maxIdx = i;
            }
        }

        getRain();
    }

    static void getRain() {
        int rainSum = 0;
        int idx = 0;

        while(idx++ < W-1) {
            int leftMax = -1;
            int rightMax = -1;

            for(int i=0; i<idx; i++)
                leftMax = Math.max(leftMax, block[i]);

            for(int i=idx+1; i<W; i++)
                rightMax = Math.max(rightMax, block[i]);

            if(block[idx] >= leftMax || block[idx] >= rightMax)
                continue;

            rainSum += (Math.min(leftMax, rightMax) - block[idx]);
        }

        System.out.println(rainSum);
    }
}
