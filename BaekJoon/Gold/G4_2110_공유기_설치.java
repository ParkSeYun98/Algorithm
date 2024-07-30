package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_2110_공유기_설치 {

    static int N, C;

    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for(int i=0; i<N; i++)
            house[i] = Integer.parseInt(br.readLine());

        Arrays.sort(house);

        int left = 1;
        int right = house[N-1]-house[0]+1;

        while(left < right) {
            int mid = (left+right)/2;

            if(getCnt(mid) < C)
                right = mid;
            else
                left = mid+1;
        }

        System.out.println(left-1);
    }

    static int getCnt(int dist) {
        int cnt = 1;
        int recent = house[0];

        for(int i=1; i<house.length; i++) {
            int now = house[i];

            if(now - recent >= dist) {
                cnt++;
                recent = now;
            }
        }

        return cnt;
    }
}
