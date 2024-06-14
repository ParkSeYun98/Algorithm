package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_5671_호텔_방_번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = "";

        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int cnt = 0;
            boolean[] visited;

            for(int i=N; i<=M; i++) {
                int[] arr = new int[10];
                int num = i;
                boolean flag = false;

                while(num > 0) {
                    if(arr[num%10] > 0) {
                        flag = true;
                        break;
                    }

                    arr[num%10]++;
                    num /= 10;
                }

                if(!flag)
                    cnt++;
            }

            System.out.println(cnt);
        }
    }
}
