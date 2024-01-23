/*
* Memory : 18564 KB
* Time : 104 ms
* */

package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1288_새로운_불면증_치료법 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int idx = 0;
            int[] countArr = new int[10];
            int cnt = 0;
            outer : while(true) {
                cnt++;
                idx++;

                int temp = N*idx;

                while(true) {
                    int rest = temp%10;
                    countArr[rest]++;
                    temp /= 10;
                    if(temp == 0)
                        break;
                }

                for(int i=0; i<countArr.length; i++) {
                    if(countArr[i] == 0)
                        continue outer;
                }

                break;
            }

            System.out.println("#" + (tc+1) + " " + cnt * N);
        }
    }
}
