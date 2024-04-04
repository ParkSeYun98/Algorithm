package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_15662_톱니바퀴_2 {

    static int T, K;

    static int[][] wheel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        wheel = new int[T+1][8];

        for(int i=1; i<=T; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                wheel[i][j] = input.charAt(j) - 48;
        }

        K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int rotateNum = Integer.parseInt(st.nextToken());
            int rotateDir = Integer.parseInt(st.nextToken());

            rotate(rotateNum, rotateDir);
        }

        print();
    }

    static void rotate(int rotateNum, int rotateDir) {
        if(rotateDir == 1)
            clockWise(rotateNum);
        else
            counterClockWise(rotateNum);

        rotateLeft(rotateNum, rotateDir);
        rotateRight(rotateNum, rotateDir);
    }

    static void rotateLeft(int rotateNum, int rotateDir) {
        if(rotateNum == 1)
            return;

        int dir, idx;

        if(rotateDir == 1)
            idx = 7;
        else
            idx = 5;

        if(wheel[rotateNum][idx] != wheel[rotateNum-1][2]) {
            if(rotateDir  == 1) {
                counterClockWise(rotateNum - 1);
                dir = -1;
            }
            else {
                clockWise(rotateNum - 1);
                dir = 1;
            }
        }
        else
            return;

        rotateLeft(rotateNum-1, dir);
    }

    static void rotateRight(int rotateNum, int rotateDir) {
        if(rotateNum == T)
            return;

        int dir, idx;

        if(rotateDir == 1)
            idx = 3;
        else
            idx = 1;

        if(wheel[rotateNum][idx] != wheel[rotateNum+1][6]) {
            if(rotateDir  == 1) {
                counterClockWise(rotateNum + 1);
                dir = -1;
            }
            else {
                clockWise(rotateNum + 1);
                dir = 1;
            }
        }
        else
            return;

        rotateRight(rotateNum+1, dir);
    }

    static void clockWise(int rotateNum) {
        int temp = wheel[rotateNum][7];

        for(int i=7; i>0; i--)
            wheel[rotateNum][i] = wheel[rotateNum][i-1];

        wheel[rotateNum][0] = temp;
    }

    static void counterClockWise(int rotateNum) {
        int temp = wheel[rotateNum][0];

        for(int i=0; i<7; i++)
            wheel[rotateNum][i] = wheel[rotateNum][i+1];

        wheel[rotateNum][7] = temp;
    }

    static void print() {
        int cnt = 0;

        for(int i=1; i<wheel.length; i++) {
            if(wheel[i][0] == 1)
                cnt++;
        }

        System.out.println(cnt);
    }
}
