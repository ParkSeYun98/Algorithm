package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2503_숫자_야구 {

    static int N, cnt;

    static Question[] questionArr;

    static class Question {
        int q;
        int s;
        int b;

        public Question(int q, int s, int b) {
            this.q = q;
            this.s = s;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        questionArr = new Question[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int Q = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            questionArr[i] = new Question(Q, S, B);
        }

        cnt = 0;

        getAnswerAmount();

        System.out.println(cnt);
    }

    static void getAnswerAmount() {
        for(int i=123; i<=987; i++) {
            String now = Integer.toString(i);

            char first = now.charAt(0);
            char second = now.charAt(1);
            char third = now.charAt(2);

            if(first == '0' || second == '0' || third == '0')
                continue;

            if(first == second || second == third || third == first)
                continue;

            boolean flag = false;

            for(int j=0; j<questionArr.length; j++) {
                String qStr = Integer.toString(questionArr[j].q);

                int strike = 0;
                int ball = 0;

                for(int a=0; a<3; a++) {
                    for(int b=0; b<3; b++) {
                        if((a==b) && (now.charAt(a)==qStr.charAt(b)))
                            strike++;

                        if((a!=b) && (now.charAt(a)==qStr.charAt(b)))
                            ball++;
                    }
                }

                if((strike==questionArr[j].s) && (ball==questionArr[j].b))
                    flag = true;
                else {
                    flag = false;
                    break;
                }
            }

            if(flag)
                cnt++;
        }
    }
}
