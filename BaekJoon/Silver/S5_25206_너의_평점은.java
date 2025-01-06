package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_25206_너의_평점은 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double sum = 0;
        double size = 0;

        for(int i=0; i<20; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            double num = Double.parseDouble(st.nextToken());
            String score = st.nextToken();
            double scoreNum = 0;

            if(score.equals("A+"))
                scoreNum = 4.5;
            else if(score.equals("A0"))
                scoreNum = 4.0;
            else if(score.equals("B+"))
                scoreNum = 3.5;
            else if(score.equals("B0"))
                scoreNum = 3.0;
            else if(score.equals("C+"))
                scoreNum = 2.5;
            else if(score.equals("C0"))
                scoreNum = 2.0;
            else if(score.equals("D+"))
                scoreNum = 1.5;
            else if(score.equals("D0"))
                scoreNum = 1.0;
            else if(score.equals("F"))
                scoreNum = 0.0;

            if(!score.equals("P"))
                size+=num;

            sum += (num*scoreNum);
        }

        sum /= size;

        System.out.println(sum);
    }
}
