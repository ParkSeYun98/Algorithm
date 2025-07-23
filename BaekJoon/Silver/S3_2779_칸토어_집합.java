package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_2779_칸토어_집합 {

    static char[] arr;

    static Map<Integer, char[]> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input;

        List<Integer> list = new ArrayList<>();
        
        while((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);

            arr = new char[(int) Math.pow(3, N)];
            Arrays.fill(arr, '-');

            erase(0, arr.length, N, 0);

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<arr.length; i++)
                sb.append(arr[i]);

            System.out.println(sb);
        }
    }

    static void erase(int st, int size, int N, int depth) {
        if(size <= 1)
            return;

        int block = size/3;

        for(int i=st+block; i<st+block*2; i++)
            arr[i] = ' ';

        erase(st, block, N, depth+1);
        erase(st+2*block, block, N, depth+1);
    }
}
