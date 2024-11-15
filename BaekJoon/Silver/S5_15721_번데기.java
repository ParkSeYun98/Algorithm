package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_15721_번데기 {

    static int zeroCnt, oneCnt, repeatCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());

        int T = Integer.parseInt(br.readLine());

        int input = Integer.parseInt(br.readLine());

        zeroCnt = 0;
        oneCnt = 0;
        repeatCnt = 2;

        System.out.println(playGame(A, T, input));
    }

    static int playGame(int A, int T, int input) {
        while(true) {
            for(int i=0; i<4; i++) {
                if(i%2 == 0)
                    zeroCnt++;
                else
                    oneCnt++;

                if(input==0 && zeroCnt==T)
                    return (zeroCnt+oneCnt-1)%A;

                if(input==1 && oneCnt==T)
                    return (zeroCnt+oneCnt-1)%A;
            }

            for(int i=0; i<repeatCnt; i++) {
                zeroCnt++;

                if(zeroCnt==T && input==0)
                    return (zeroCnt+oneCnt-1)%A;
            }

            for(int i=0; i<repeatCnt; i++) {
                oneCnt++;

                if(oneCnt==T && input==1)
                    return (zeroCnt+oneCnt-1)%A;
            }

            repeatCnt++;
        }
    }
}
