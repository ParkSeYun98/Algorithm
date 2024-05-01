package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G5_13023_ABCDE {

    static int N, M;
    static boolean flag;

    static boolean[] visited;

    static List<Integer>[] friend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friend = new ArrayList[N];

        for(int i=0; i<friend.length; i++)
            friend[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend[a].add(b);
            friend[b].add(a);
        }

        for(int i=0; i<N; i++) {
            visited = new boolean[N];

            DFS(1, i);

            if(flag) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    static void DFS(int depth, int idx) {
        if(depth == 5) {
            flag = true;
            return;
        }

        visited[idx] = true;

        for (Integer fr : friend[idx]) {
            if(!visited[fr])
                DFS(depth+1, fr);
        }

        visited[idx] = false;
    }
}
