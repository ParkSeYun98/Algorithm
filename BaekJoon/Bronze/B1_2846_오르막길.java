package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1_2846_오르막길 {

    static int N, max;

    static int[] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        max = 0;
        road = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            road[i] = Integer.parseInt(st.nextToken());

        getHigherRoad();

        System.out.println(max);
    }

    static void getHigherRoad() {
        int sum = 0;

        for(int i=0; i<road.length-1; i++) {
            if(road[i+1] > road[i]) {
                sum += road[i + 1] - road[i];
                max = Math.max(max, sum);
            }
            else
                sum = 0;
        }
    }
}
