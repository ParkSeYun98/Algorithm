package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_1213_펠린드롬_만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] palindrome = br.readLine().toCharArray();
        int[] cntArr = new int[26];

        for(int i=0; i<palindrome.length; i++)
            cntArr[palindrome[i] - 'A']++;

        int oddCnt = 0;
        StringBuilder answer = new StringBuilder();
        int oddIdx = -1;

        for(int i=0; i<cntArr.length; i++) {
            if(cntArr[i] % 2 == 1) {
                oddCnt++;
                oddIdx = i;
            }
        }

        if(oddCnt > 1 || (oddCnt == 1 && palindrome.length % 2 == 0)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for(int i=0; i<cntArr.length; i++) {
            for(int j=0; j<cntArr[i]/2; j++)
                answer.append((char) (i + 'A'));
        }

        if(oddCnt == 1)
            answer.append((char) (oddIdx + 'A'));

        for(int i=cntArr.length-1; i>=0; i--) {
            for(int j=0; j<cntArr[i]/2; j++)
                answer.append((char) (i + 'A'));
        }

        System.out.println(answer);
    }
}
