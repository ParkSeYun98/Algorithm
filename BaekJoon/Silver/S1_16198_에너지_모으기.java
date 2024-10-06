package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S1_16198_에너지_모으기 {

    static int N, energy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            list.add(Integer.parseInt(st.nextToken()));

        energy = 0;

        DFS(0, list);

        System.out.println(energy);
    }

    static void DFS(int partSum, List<Integer> list) {
        if(list.size() <= 2) {
            energy = Math.max(energy, partSum);

            return;
        }

        for(int i=1; i<list.size()-1; i++) {
            List<Integer> tempList = new ArrayList<>(list);
            tempList.remove(i);

            DFS(partSum + (list.get(i-1) * list.get(i+1)), tempList);
        }
    }
}
