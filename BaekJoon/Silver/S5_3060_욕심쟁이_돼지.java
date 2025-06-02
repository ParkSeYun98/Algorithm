package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S5_3060_욕심쟁이_돼지 {

    static int N, day;
    static long idx, feed, sum;
    static String s;

    static long[] arr, pig;

    static Queue<long[]> present;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());

            day = 0; sum = 0;

            arr = new long[6];
            present = new LinkedList<>();

            s = br.readLine();
            st = new StringTokenizer(s);

            for (int j=0; j<6; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                present.add(new long[]{ j, arr[j]});
                sum += arr[j];
            }

            while (true) {
                if (sum > N) {
                    System.out.println(day + 1);
                    break;
                }

                sum = 0;

                for (int j=0; j<6; j++) {
                    pig = present.poll();
                    idx = pig[0];
                    feed = pig[1];

                    feed += arr[(int) (idx+1)%6] + arr[(int) (idx+5)%6] + arr[(int) (idx+3)%6];
                    present.add(new long[] { idx, feed });
                }

                for (int j=0; j<6; j++) {
                    pig = present.poll();
                    idx = pig[0];
                    feed = pig[1];

                    arr[(int) idx] = feed;
                    sum += arr[(int) idx];
                }

                for (int j=0; j<6; j++)
                    present.add(new long[]{ j, arr[j]});

                day++;
            }
        }
    }
}
