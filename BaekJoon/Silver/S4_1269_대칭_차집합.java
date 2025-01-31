package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S4_1269_대칭_차집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        HashSet<Integer> hashSet = new HashSet();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<sizeA; i++)
            hashSet.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<sizeB; i++)
            hashSet.add(Integer.parseInt(st.nextToken()));

        System.out.println((hashSet.size()-sizeA) + (hashSet.size()-sizeB));
    }
}
