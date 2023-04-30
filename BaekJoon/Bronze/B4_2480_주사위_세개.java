package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B4_2480_주사위_세개 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dice = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<3; i++)
            dice[i] = Integer.parseInt(st.nextToken());

        int result = 0;

        Arrays.sort(dice);

        if(dice[0] == dice[1] && dice[1] == dice[2])
            result = 10000 + dice[0]*1000;

        if(dice[0]==dice[1] && dice[1] != dice[2])
            result = 1000 + dice[0]*100;
        else if(dice[1]==dice[2] && dice[2] != dice[0])
            result = 1000 + dice[1]*100;
        else if(dice[2]==dice[0] && dice[0] != dice[1])
            result = 1000 + dice[2]*100;

        if(dice[0] != dice[1] && dice[1] != dice[2])
            result = dice[2]*100;


        System.out.println(result);
    }
}
