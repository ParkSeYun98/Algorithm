package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4_1822_차집합 {

    static int nA, nB;

    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        A = new int[nA];
        B = new int[nB];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<nA; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<nB; i++)
            B[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;

        TreeSet<Integer> treeSet = new TreeSet<>();

        for(int i=0; i<A.length; i++)
            treeSet.add(A[i]);

        for(int i=0; i<B.length; i++) {
            if(treeSet.contains(B[i]))
                treeSet.remove(B[i]);
        }

        System.out.println(treeSet.size());

        for (Integer num : treeSet)
            System.out.print(num + " ");
    }
}
