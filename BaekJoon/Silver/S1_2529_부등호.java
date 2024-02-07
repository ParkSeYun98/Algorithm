/*
* Memory : 27356 KB
* Time : 980 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_2529_부등호 {

    static int k;

    static String[] arr;
    static boolean[] visited;
    static int[] order;

    static Map<String, Long> candidateMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        arr = new String[k];
        visited = new boolean[10];
        order = new int[k+1];
        candidateMap = new HashMap<>();

        for(int i=0; i<k; i++)
            arr[i] = st.nextToken();

        findOrder(0);
        findMaxAndMin();
    }

    static void findOrder(int depth) {
        if(depth == k+1) {
            check();
            return;
        }

        for(int i=0; i<=9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                findOrder(depth+1);
                visited[i] = false;
            }
        }
    }

    static void check() {
        boolean fail = false;

        for(int i=0; i<order.length-1; i++) {
            if(arr[i].equals("<")) {
                if(order[i] >= order[i+1]) {
                    fail = true;
                    break;
                }
            }
            else if(arr[i].equals(">")){
                if(order[i] <= order[i+1]) {
                    fail = true;
                    break;
                }
            }
        }

        if(!fail) {
            StringBuilder sb = new StringBuilder();

            for (int o : order)
                sb.append(o);

            candidateMap.put(sb.toString(), Long.parseLong(sb.toString()));
        }
    }

    static void findMaxAndMin() {
        int maxIdx = 0;
        int minIdx = 0;

        List<Map.Entry<String, Long>> entryList = new LinkedList<>(candidateMap.entrySet());

        for(int i=1; i<entryList.size(); i++) {
            if(entryList.get(maxIdx).getValue() < entryList.get(i).getValue())
                maxIdx = i;

            if(entryList.get(minIdx).getValue() > entryList.get(i).getValue())
                minIdx = i;
        }

        System.out.println(entryList.get(maxIdx).getKey());
        System.out.println(entryList.get(minIdx).getKey());
    }
}
