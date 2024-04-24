package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1940_주몽 {

    static int N, M;

    static int[] material;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        material = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            material[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(material);

        makeArmor();
    }

    static void makeArmor() {
        int cnt = 0;
        int start = 0;
        int end = N - 1;

        while(start < end) {
            int sum = material[start] + material[end];

            if(sum > M)
                end--;
            else if(sum < M)
                start++;
            else {
                cnt++;
                start++;
                end--;
            }
        }

        System.out.println(cnt);
    }
}
