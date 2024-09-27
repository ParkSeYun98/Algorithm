package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S5_5800_성적_통계 {

    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());

            List<Integer> scoreList = new ArrayList<>();

            for(int j=0; j<N; j++)
                scoreList.add(Integer.parseInt(st.nextToken()));

            Collections.sort(scoreList);

            int min = scoreList.get(0);
            int max = scoreList.get(scoreList.size()-1);
            int gap = 0;

            for(int j=0; j<N-1; j++)
                gap = Math.max(gap, Math.abs(scoreList.get(j) - scoreList.get(j+1)));

            System.out.println("Class " + (i+1));
            System.out.println("Max " + max + ", Min " + min + ", Largest gap " + gap);
        }
    }
}
