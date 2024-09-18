package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S2_28447_마라탕_재료_고르기 {

    static int N, K, max;

    static boolean[] visited;

    static int[][] recipe;

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;

        recipe = new int[N][N];
        visited = new boolean[N];
        list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++)
                recipe[i][j] = Integer.parseInt(st.nextToken());
        }

        findRecipe(0, 0);

        System.out.println(max);
    }

    static void findRecipe(int depth, int start) {
        if(depth == K) {
            int tasteScore = 0;

            for (int i=0; i<list.size(); i++) {
                for (int j=i+1; j<list.size(); j++)
                    tasteScore += recipe[list.get(i)][list.get(j)];
            }

            max = Math.max(max, tasteScore);
            return;
        }

        for(int i=start; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(i);
                findRecipe(depth+1, i+1);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
