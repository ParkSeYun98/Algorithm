/*
* Memory : 11668 KB
* Time : 80 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1068_트리 {

    static int N, eraseNode, startNode, cnt;

    static int[] node;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        node = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++) {
            node[i] = Integer.parseInt(st.nextToken());

            if(node[i] == -1)
                startNode = i;
        }

        eraseNode = Integer.parseInt(br.readLine());

        visited[startNode] = true;
        Backtracking(startNode);
        leafCheck();

        System.out.println(cnt);
    }

    static void Backtracking(int depth) {
        boolean flag = false;

        if(depth == eraseNode)
            return;

        visited[depth] = true;

        for(int i=0; i<N; i++) {
            if(depth == node[i]) {
                flag = true;
                Backtracking(i);
            }
        }

        if(!flag)
            cnt++;
    }

    static void leafCheck() {
        boolean flag = false;

        for(int i=0; i<N; i++) {
            if (node[i] == node[eraseNode] && visited[i]) {
                flag = true;
                break;
            }
        }

        if(node[eraseNode] != -1 && !flag)
            cnt++;
    }
}
