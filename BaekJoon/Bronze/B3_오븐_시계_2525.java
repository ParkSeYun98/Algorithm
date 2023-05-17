package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_오븐_시계_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int nowH = Integer.parseInt(st.nextToken());
        int nowM = Integer.parseInt(st.nextToken());

        int plusM = Integer.parseInt(br.readLine());
        int plusH = 0;

        if(plusM + nowM >= 60) {
            plusH = (plusM + nowM) / 60;
            nowM = (plusM + nowM) % 60;
        }
        else
            nowM += plusM;

        nowH += plusH;

        nowH %= 24;

        System.out.println(nowH + " " + nowM);
    }
}
