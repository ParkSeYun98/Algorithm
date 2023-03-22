package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_10431_줄세우기 {
    private static int cnt;

    private static int[] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=P; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            int T = Integer.parseInt(st.nextToken());

            students = new int[20];

            for(int i=0; i<20; i++)
                students[i] = Integer.parseInt(st.nextToken());

            cnt = 0;

            findMyPosition();

            System.out.println(T + " " + cnt);
        }
    }

    public static void findMyPosition() {
        for(int i=1; i<20; i++) {
            for(int j=0; j<=i-1; j++) {
                if(students[i] < students[j])
                    cnt++;
            }
        }
    }
}
