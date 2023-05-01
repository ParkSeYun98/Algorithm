package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_2490_윷놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int zeroCnt = 0;
            int oneCnt = 0;

            for(int j=0; j<4; j++) {
                int input = Integer.parseInt(st.nextToken());

                if(input == 0)
                    zeroCnt++;
                else
                    oneCnt++;
            }

            if(zeroCnt == 1)
                System.out.println("A");
            else if(zeroCnt == 2)
                System.out.println("B");
            else if(zeroCnt == 3)
                System.out.println("C");
            else if(zeroCnt == 4)
                System.out.println("D");
            else
                System.out.println("E");
        }
    }
}
