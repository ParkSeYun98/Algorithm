package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S4_5568_카드_놓기 {

    static int n, k;

    static int[] cardArr, selected;
    static boolean[] visited;

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        cardArr = new int[n];
        visited = new boolean[n];
        selected = new int[k];
        list = new ArrayList<>();

        for(int i=0; i<n; i++)
            cardArr[i] = Integer.parseInt(br.readLine());

        pickCard(0);

        System.out.println(list.size());
    }

    static void pickCard(int depth) {
        if(depth == k) {
            int num = makeNumber();

            if(!list.contains(num))
                list.add(num);

            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[depth] = cardArr[i];
                pickCard(depth+1);
                visited[i] = false;
            }
        }
    }

    static int makeNumber() {
        StringBuilder sb = new StringBuilder();

        for (int num : selected)
            sb.append(num);

        return Integer.parseInt(sb.toString());
    }
}
