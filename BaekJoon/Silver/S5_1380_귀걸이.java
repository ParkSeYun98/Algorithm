package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S5_1380_귀걸이 {

    static int n, idx;

    static int[] cntArr;

    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        idx = 0;

        while(true) {
            n = Integer.parseInt(br.readLine());

            if(n == 0)
                return;
            else
                idx++;

            list = new ArrayList<>();

            for(int i=0; i<n; i++)
                list.add(br.readLine());

            cntArr = new int[list.size()];

            for(int i=0; i<(2*n-1); i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int num = Integer.parseInt(st.nextToken());

                cntArr[num-1]++;
            }

            for(int i=0; i<cntArr.length; i++) {
                if(cntArr[i] == 1)
                    System.out.println(idx + " " + list.get(i));
            }
        }
    }
}
