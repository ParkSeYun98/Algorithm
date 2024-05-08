package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_20207_달력 {

    static int N;

    static int[] calender;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        calender = new int[366];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            for(int j=S; j<=E; j++)
                calender[j]++;
        }

        int max = 0;
        int length = 0;
        int sum = 0;

        for(int i=0; i<calender.length; i++) {
            if(calender[i] == 0) {
                sum += (max * length);
                max = 0;
                length = 0;
                continue;
            }

            max = Math.max(max, calender[i]);
            length++;
        }

        sum += (max * length);

        System.out.println(sum);
    }
}
