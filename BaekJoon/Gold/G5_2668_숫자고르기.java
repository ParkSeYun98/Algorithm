package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class G5_2668_숫자고르기 {

    static int N;

    static int[] arr;
    static boolean[] visited;

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList<>();

        for(int i=1; i<=N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            visited[i] = true;
            DFS(i, i);
            visited[i] = false;
        }

        Collections.sort(list);

        System.out.println(list.size());

        for (Integer now : list)
            System.out.println(now);
    }

    static void DFS(int start, int target) {
        int next = arr[start];

        if(!visited[next]) {
            visited[next] = true;
            DFS(next, target);
            visited[next] = false;
        }

        if(next == target)
            list.add(target);
    }
}
