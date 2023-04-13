package BaekJoon.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3_1305_광고 {
    static int L;
    static String input;

    static int[] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine());

        input = br.readLine();

        table = new int[input.length()];
        getTable();

        System.out.println(input.length() - table[table.length-1]);
    }

    static void getTable() {
        int idx = 0;

        for(int i=1; i<table.length; i++) {
            while(idx>0 && input.charAt(idx) != input.charAt(i))
                idx = table[idx-1];

            if(input.charAt(idx) == input.charAt(i))
                table[i] = ++idx;
        }
    }
}
