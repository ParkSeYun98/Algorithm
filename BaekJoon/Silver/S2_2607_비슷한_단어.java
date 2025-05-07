package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_2607_비슷한_단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        int[] inputArr = new int[27];

        for(int i=0; i<input.length(); i++)
            inputArr[input.charAt(i) - 'A']++;

        int cnt = 0;

        for(int i=1; i<N; i++) {
            String temp = br.readLine();

            if(Math.abs(input.length() - temp.length()) > 1)
                continue;

            int[] tempArr = new int[27];

            for(int j=0; j<temp.length(); j++)
                tempArr[temp.charAt(j) - 'A']++;

            boolean flag = false;
            int oneCnt = 0;
            int minusOneCnt = 0;

            for(int j=0; j<tempArr.length; j++) {

                if(inputArr[j] - tempArr[j] == 1)
                    oneCnt++;
                else if(inputArr[j] - tempArr[j] == -1)
                    minusOneCnt++;

                if(Math.abs(inputArr[j] - tempArr[j]) > 1) {
                    flag = true;
                    break;
                }

                if(oneCnt > 1 || minusOneCnt > 1) {
                    flag = true;
                    break;
                }
            }

            if(!flag)
                cnt++;
        }

        System.out.println(cnt);
    }
}
