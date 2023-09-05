package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_20055_컨베이어_벨트_위의_로봇 {

    private static int N;
    private static int K;

    private static int[] durability;
    private static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        durability = new int[2*N];
        robot = new boolean[2*N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<2*N; i++)
            durability[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;

        while(true) {
            if(!checkConveyorBelt())
                break;

            rotateConveyorBelt();

            moveRobot();

            onRobot();

            cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean checkConveyorBelt() {
        int noDurabilityCnt = 0;

        for(int i=0; i<durability.length; i++) {
            if(durability[i] == 0)
                noDurabilityCnt++;

            if(noDurabilityCnt >= K)
                return false;
        }

        return true;
    }

    public static void rotateConveyorBelt() {
        int temp = durability[durability.length-1];

        for(int i=durability.length-1; i>0; i--) {
            durability[i] = durability[i-1];
        }

        durability[0] = temp;

        for(int i=robot.length-1; i>0; i--)
            robot[i] = robot[i-1];

        robot[0] = false;
        robot[N-1] = false;
    }

    public static void moveRobot() {
        for(int i=N-1; i>0; i--) {
            if(robot[i-1] && !robot[i] && durability[i] > 0) {
                robot[i-1] = false;
                robot[i] = true;
                durability[i]--;
            }
        }
    }

    public static void onRobot() {
        if(durability[0] > 0) {
            robot[0] = true;
            durability[0]--;
        }
    }
}
