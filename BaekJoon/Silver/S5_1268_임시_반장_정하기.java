package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_1268_임시_반장_정하기 {

    static int N;

    static int[][] student;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        student = new int[N][5];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<5; j++)
                student[i][j] = Integer.parseInt(st.nextToken());
        }

        pickBoss();
    }

    static void pickBoss() {
        int[] result = new int[N];

        for(int i=0; i<N; i++) {
            outer : for(int j=0; j<N; j++) {
                if(i == j)
                    continue;

                for(int k=0; k<5; k++) {
                    if(student[i][k] == student[j][k]) {
                        result[i]++;
                        continue outer;
                    }
                }
            }
        }

        int max = -1;
        int maxIdx = 0;

        for(int i=0; i<result.length; i++) {
            if(max < result[i]) {
                max = result[i];
                maxIdx = i;
            }
        }

        System.out.println(maxIdx+1);
    }
}
