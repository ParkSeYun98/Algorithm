/*
* Memory : 11508 KB
* Time : 80 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_2891_카약과_강풍 {

    static int N, S, R;

    static int[] kayak;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        kayak = new int[N+1];
        Arrays.fill(kayak, 1);

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=S; i++)
            kayak[Integer.parseInt(st.nextToken())]--;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=R; i++)
            kayak[Integer.parseInt(st.nextToken())]++;

        start();
    }

    static void start() {
        int cnt = 0;

        for(int i=1; i<=N-1; i++) {
           if(kayak[i] == 0 && kayak[i+1] == 2) {
               kayak[i]++;
               kayak[i+1]--;
           }
           else if(kayak[i+1] == 0 && kayak[i] == 2) {
               kayak[i]--;
               kayak[i+1]++;
           }
        }

        for (int i : kayak) {
            if(i == 0)
                cnt++;
        }

        System.out.println(cnt);
    }
}
