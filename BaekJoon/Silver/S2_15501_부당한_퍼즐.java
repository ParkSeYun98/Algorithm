package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S2_15501_부당한_퍼즐 {

    static int n;

    static List<Integer> listA, listB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        listA = new ArrayList<>();
        listB = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++)
            listA.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++)
            listB.add(Integer.parseInt(st.nextToken()));

        boolean flagA = false;
        boolean flagB = false;

        for(int i=0; i<n; i++) {
            if(listA.get(0) != listB.get(i))
                continue;

            for(int j=0; j<n; j++) {
                if(listA.get(j) == listB.get((i+j)%4))
                    continue;

                flagA = true;
                break;
            }

            for(int j=0; j<n; j++) {
                if(listA.get(j) == listB.get((n+i-j)%n))
                    continue;

                flagB = true;
                break;
            }

            if(flagA && flagB)
                System.out.println("bad puzzle");
            else
                System.out.println("good puzzle");
        }
    }
}
