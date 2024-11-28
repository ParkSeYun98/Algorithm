package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S4_2422_한윤정이_이탈리아에_가서_아이스크림을_사먹는데 {

    static int N, M, cnt;

    static boolean[] visited;
    static int[] mix;

    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=0; i<list.length; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        cnt = 0;
        mix = new int[3];
        visited = new boolean[N+1];

        combination(0, 1);

        System.out.println(cnt);
    }

    static void combination(int depth, int start) {
        if(depth == 3) {
            boolean flag = true;

            outer: for(int i=0; i<mix.length; i++) {
                for(int j=i+1; j<mix.length; j++) {
                    if(list[mix[i]].contains(mix[j])) {
                        flag = false;
                        break outer;
                    }
                }
            }

            if(flag)
                cnt++;

            return;
        }

        for(int i=start; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                mix[depth] = i;
                combination(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
