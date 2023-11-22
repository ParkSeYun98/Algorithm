package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_2847_게임을_만든_동준이 {

    private static int N;
    private static int cnt;

    private static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = 0;

        score = new int[N];

        for(int i=0; i<N; i++)
            score[i] = Integer.parseInt(br.readLine());

        adjustScore();

        System.out.println(cnt);
    }

    public static void adjustScore() {
        for(int i=N-1; i>0; i--) {
            while(score[i] <= score[i-1]) {
                score[i-1]--;
                cnt++;
            }
        }
    }
}
