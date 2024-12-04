package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_19949_영재의_시험 {

    static int cnt;

    static int[] answer, test;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        cnt = 0;
        answer = new int[10];
        test = new int[10];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<10; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        getTest(0);

        System.out.println(cnt);
    }

    static void getTest(int depth) {
        if(depth == 10) {
            if(check() >= 5)
                cnt++;

            return;
        }

        for(int i=1; i<=5; i++) {

            if(depth>=2 && (i==test[depth-1] && i==test[depth-2]))
                continue;

            test[depth] = i;
            getTest(depth+1);
        }
    }

    static int check() {
        int correctCnt = 0;

        for(int i=0; i<10; i++) {
            if(test[i] == answer[i])
                correctCnt++;
        }

        return correctCnt;
    }
}
