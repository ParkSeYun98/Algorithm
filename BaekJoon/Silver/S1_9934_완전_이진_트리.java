package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S1_9934_완전_이진_트리 {

    static int K;

    static int[] order;

    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        order = new int[(int) (Math.pow(2, K) - 1)];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<order.length; i++)
            order[i] = Integer.parseInt(st.nextToken());

        int depth = 0;
        int temp = order.length;

        while(temp>0) {
            temp /= 2;
            depth++;
        }

        depth++;

        list = new ArrayList[depth];

        for(int i=0; i<depth; i++)
            list[i] = new ArrayList<>();

        recur(0, order.length-1, 0);

        for(int i=0; i<list.length; i++) {
            for(int j=0; j<list[i].size(); j++)
                System.out.print(list[i].get(j) + " ");

            System.out.println();
        }
    }

    static void recur(int start, int end, int depth) {
        if(start > end)
            return;

        int mid = (start + end) / 2;

        list[depth].add(order[mid]);

        recur(start, mid-1, depth+1);
        recur(mid+1, end, depth+1);
    }
}
