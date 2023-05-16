package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_2884_알람_시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int temp = 0;

        if(M < 45) {
            temp = 1;
            M = 60 - (45 - M);
        }
        else
            M -= 45;

        if(H == 0) {
            if(temp == 1)
                H = 23;
        }
        else
            H -= temp;

        System.out.println(H + " " + M);
    }
}
