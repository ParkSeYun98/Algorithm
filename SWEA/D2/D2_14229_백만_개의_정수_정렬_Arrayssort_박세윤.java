package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_14229_백만_개의_정수_정렬_Arrayssort_박세윤 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[1000000];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<1000000; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        System.out.println(arr[500000]);
    }
}
