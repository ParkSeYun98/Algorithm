package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_연속_부분_수열_합의_개수 {

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for(int i=1; i<=elements.length; i++) {
            int start = 0;
            int prefixSum = 0;

            for(int j=0; j<i; j++)
                prefixSum += elements[j];

            set.add(prefixSum);

            while(true) {
                if(start >= elements.length-1)
                    break;

                prefixSum -= elements[start];
                prefixSum += elements[(start+i)%elements.length];
                set.add(prefixSum);

                start++;
            }
        }

        return set.size();
    }
}
