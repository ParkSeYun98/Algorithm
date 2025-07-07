package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1_10798_세로읽기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Character>[] list = new ArrayList[5];

        for(int i=0; i<list.length; i++)
            list[i] = new ArrayList<>();

        int maxSize = -1;

        for(int i=0; i<5; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                list[i].add(input.charAt(j));

            if(maxSize < list[i].size())
                maxSize = list[i].size();
        }

        String result = "";

        for(int i=0; i<maxSize; i++) {
            for(int j=0; j<5; j++) {
                List<Character> temp = list[j];

                if(temp.size() > i)
                    result += list[j].get(i);
            }
        }

        System.out.println(result);
    }
}
