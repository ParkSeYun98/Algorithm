package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_4307_개미 {

    static int l, n;

    static int[] first;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            l = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            first = new int[n];

            for(int i=0; i<n; i++)
                first[i] = Integer.parseInt(br.readLine());

            solve();
        }
    }

    static void solve() {
        int half = l/2;

        int minTemp = l;
        int minIdx = -1;
        int maxTemp = 0;
        int maxIdx = -1;

        for(int i=0; i<first.length; i++) {
            if(minTemp > Math.abs(half - first[i])) {
                minIdx = i;
                minTemp = Math.abs(half - first[i]);
            }

            if(maxTemp < Math.abs(half - first[i])) {
                maxIdx = i;
                maxTemp = Math.abs(half - first[i]);
            }
        }

        int min = Math.min(first[minIdx], l - first[minIdx]);
        int max = Math.max(first[maxIdx], l - first[maxIdx]);

        System.out.println(min + " " + max);
    }
}
