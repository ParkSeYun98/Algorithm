package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S2_5567_결혼식 {

    private static int n;
    private static int m;

    private static boolean[] visited;

    private static List<Integer>[] inviteList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        inviteList = new ArrayList[n+1];

        for(int i=0; i<inviteList.length; i++)
            inviteList[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            inviteList[a].add(b);
            inviteList[b].add(a);
        }

        DFS(0, 1);

        compute();
    }

    public static void DFS(int depth, int start) {
        if(depth == 2)
            return;

        for(int i=0; i<inviteList[start].size(); i++) {
                visited[inviteList[start].get(i)] = true;
                DFS(depth+1, inviteList[start].get(i));
        }
    }

    public static void compute() {
        int cnt = 0;

        for(int i=2; i<visited.length; i++) {
            if(visited[i])
                cnt++;
        }

        System.out.println(cnt);
    }
}
