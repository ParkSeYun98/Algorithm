package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S5_25757_임스와_함께하는_미니게임 {

    static int N, cnt;
    static String type;

    static boolean[] visited;

    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        type = st.nextToken();

        set = new HashSet<>();

        for(int i=0; i<N; i++)
            set.add(br.readLine());

        cnt = 0;
        visited = new boolean[set.size()];

        switch(type) {
            case "Y" :
                cnt = set.size();
                break;
            case "F" :
                cnt = set.size()/2;
                break;
            case "O" :
                cnt = set.size()/3;
                break;
        }

        System.out.println(cnt);
    }
}
