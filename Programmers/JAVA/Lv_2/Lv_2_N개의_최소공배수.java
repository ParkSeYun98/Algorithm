package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_N개의_최소공배수 {

    public int solution(int[] arr) {
        Arrays.sort(arr);

        int n = arr[arr.length-1];

        while(true) {
            boolean flag = false;

            for(int i=0; i<arr.length; i++) {
                if(n%arr[i] != 0) {
                    flag = true;
                    break;
                }
            }

            if(flag)
                n++;
            else
                break;
        }

        return n;
    }
}
