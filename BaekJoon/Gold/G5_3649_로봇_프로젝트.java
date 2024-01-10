/*
Memory : 306292 KB
Time : 1796 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_3649_로봇_프로젝트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = null;

        while((temp = br.readLine()) != null) {
            int x = Integer.parseInt(temp) * 10000000;
            int n = Integer.parseInt(br.readLine());

            int[] l = new int[n];

            for(int i=0; i<n; i++)
                l[i] = Integer.parseInt(br.readLine());

            Arrays.sort(l);

            binarySearch(x, l);
        }
    }

    public static void binarySearch(int x, int[] l) {
        int left = 0;
        int right = l.length-1;

        while(left < right) {
            int sum = l[left] + l[right];

            if(sum == x) {
                System.out.println("yes " + l[left] + " " + l[right]);
                return;
            }
            else if(sum >= x)
                right--;
            else
                left++;
        }

        System.out.println("danger");
    }
}
