package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_1484_다이어트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());

        long start = 1;
        long end = 2;
        boolean flag = false;

        while(end < 100000) {
            long pointA = start * start;
            long pointB = end * end;

            if(pointB - pointA <= G) {
                if(pointB - pointA == G) {
                    flag = true;
                    System.out.println(end);
                }

                end++;
            }
            else if(pointB - pointA > G)
                start++;
        }

        if(!flag)
            System.out.println(-1);
    }
}
