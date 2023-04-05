package SWEA.모의_SW_역량_테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의_SW_역량_테스트_4013_특이한_자석 {
    static int K;

    static int[][] wheel;
    static int[][] rotateInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            K = Integer.parseInt(br.readLine());

            wheel = new int[5][9];

            for(int i=1; i<=4; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=1; j<=8; j++)
                    wheel[i][j] = Integer.parseInt(st.nextToken());
            }

            rotateInfo = new int[K][2];

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<2; j++)
                    rotateInfo[i][j] = Integer.parseInt(st.nextToken());
            }

            Rotate();

            System.out.println("#" + tc + " " + getScore());
        }
    }

    static void Rotate() {
        for(int i=0; i<K; i++) {
            int wheelNum = rotateInfo[i][0];
            int direction = rotateInfo[i][1];

            int[] dir = new int[5];
            getDirection(dir, direction, wheelNum);

            rotateOneTime(dir);
        }
    }

    static void getDirection(int[] dir, int nowDir, int wheelNum) {
        dir[wheelNum] = nowDir;

        if(wheelNum == 1)
            rightCheck(dir, nowDir, wheelNum);
        else if(wheelNum == 4) {
            leftCheck(dir, nowDir, wheelNum);
        }
        else {
            leftCheck(dir, nowDir, wheelNum);
            rightCheck(dir, nowDir, wheelNum);
        }
    }

    static void leftCheck(int[] dir, int nowDir, int wheelNum) {
        int t = wheelNum;

        while (t != 1) {

            if (!sameCheck(t - 1, t))
                if(nowDir == 1)
                    nowDir = -1;
                else
                    nowDir = 1;
            else
                break;

            t--;
            dir[t] = nowDir;
        }
    }

    static void rightCheck(int[] dir, int nowDir, int wheelNum) {
        int t = wheelNum;

        while (t != 4) {

            if (!sameCheck(t, t + 1)) {
                if(nowDir == 1)
                    nowDir = -1;
                else
                    nowDir = 1;
            }
            else
                break;

            t++;
            dir[t] = nowDir;
        }
    }

    static boolean sameCheck(int wheelNumA, int wheelNumB) {
        return wheel[wheelNumA][3] == wheel[wheelNumB][7];
    }

    static void rotateOneTime(int[] dir) {
        for(int i=1; i<=4; i++) {
            if(dir[i] == 1)
                clockwise(i);
            else if(dir[i] == -1)
                counterClockwise(i);
        }
    }

    static void clockwise(int clockNum) {
        int temp = wheel[clockNum][8];

        for(int i=8; i>1; i--)
            wheel[clockNum][i] = wheel[clockNum][i-1];

        wheel[clockNum][1] = temp;
    }

    static void counterClockwise(int clockNum) {
        int temp = wheel[clockNum][1];

        for(int i=1; i<8; i++)
            wheel[clockNum][i] = wheel[clockNum][i+1];

        wheel[clockNum][8] = temp;
    }

    static int getScore() {
        int sum = 0;

        for(int i=1; i<=4; i++)
            sum += wheel[i][1] * Math.pow(2, i-1);

        return sum;
    }
}
