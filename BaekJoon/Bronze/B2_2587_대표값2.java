package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2_2587_대표값2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];

        for(int i=0; i<5; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int sum = 0;

        for (int j : arr)
            sum += j;

        System.out.println(sum / 5);
        System.out.println(arr[2]);
    }
}
