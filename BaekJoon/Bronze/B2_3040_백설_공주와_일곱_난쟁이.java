package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_3040_백설_공주와_일곱_난쟁이 {

    static int[] arr, ans, result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];
        ans = new int[7];
        result = new int[7];
        visited = new boolean[9];

        for(int i=0; i<arr.length; i++)
            arr[i] = Integer.parseInt(br.readLine());

        findSeven(0, 0);

        for (int num : result)
            System.out.println(num);
    }

    static void findSeven(int depth, int start) {
        if(depth == 7) {
            int sum = 0;

            for (int num : ans)
                sum += num;

            if(sum == 100)
                result = ans.clone();

            return;
        }

        for(int i=start; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = arr[i];
                findSeven(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
