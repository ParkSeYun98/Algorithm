/*
* Memory : 70352 KB
* Time : 336 ms
* */

package BaekJoon.Gold;

import java.io.IOException;
import java.util.Scanner;

public class G5_1107_리모컨 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int min = Math.abs(N - 100);
        boolean[] buttonArr = new boolean[10];

        for(int i=0; i<M; i++)
            buttonArr[sc.nextInt()] = true;

        for(int i=0; i<=999999; i++) {
            String temp = String.valueOf(i);
            boolean flag = false;

            for(int j=0; j<temp.length(); j++) {
                if(buttonArr[temp.charAt(j) - '0']) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                int tmp = Math.abs(N - i) + temp.length();
                min = Math.min(min, tmp);
            }
        }

        System.out.println(min);
    }
}
