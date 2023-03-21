package SWEA.D3;

import java.io.*;
import java.util.*;

class D3_5215_햄버거_다이어트
{
    public static int N;
    public static int L;

    public static int[] score;
    public static int[] calory;

    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            score = new int[N];
            calory = new int[N];

            max = 0;

            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                score[j] = Integer.parseInt(st.nextToken());
                calory[j] = Integer.parseInt(st.nextToken());
            }

            DFS(0, 0, 0);

            System.out.println("#" + i + " " + max);
        }
    }

    public static void DFS(int scoresum, int calorysum, int cnt) {
        if(calorysum > L)
            return;


        if(cnt == N) {
            max = Math.max(max, scoresum);
            return;
        }

        // 다음 재료를 집은 경우
        DFS(scoresum + score[cnt], calorysum + calory[cnt], cnt+1);
        // 다음 재료를 집지 않은 경우
        DFS(scoresum, calorysum, cnt+1);
    }
}