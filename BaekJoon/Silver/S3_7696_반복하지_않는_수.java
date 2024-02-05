/*
* Memory : 132736 KB
* Time : 220 ms
* */

package BaekJoon.Silver;

import java.io.*;

public class S3_7696_반복하지_않는_수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;

        int[] bitArr = new int[30000001];
        int[] answer = new int[1000001];

        for(int i=0; i<10; i++) {
            bitArr[i] = 1 << i;
            answer[i] = i;
        }

        int idx = 10;
        int cnt = 10;

        while(cnt <= 1000000) {
            // ????
            if(bitArr[idx/10] == 0) {
                ++idx;

                continue;
            }

            // 반복하지 않는 수 일때
            if((bitArr[idx/10] & bitArr[idx%10]) == 0) {
                bitArr[idx] = bitArr[idx/10] | bitArr[idx%10];

                answer[cnt] = idx;
                cnt++;
            }

            idx++;
        }

        while(!((n = Integer.parseInt(br.readLine())) == 0))
            System.out.println(answer[n]);
    }
}
