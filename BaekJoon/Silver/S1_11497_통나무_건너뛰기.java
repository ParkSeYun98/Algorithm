/*
* Memory : 49184 KB
* Time : 452 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_11497_통나무_건너뛰기 {

    static int N;

    static int[] tree, sortedTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            tree = new int[N];
            sortedTree = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++)
                tree[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(tree);

            int idx1 = 0;
            int idx2 = tree.length - 1;

            for(int i=0; i<tree.length; i++) {
                if(i%2 == 0)
                    sortedTree[idx1++] = tree[i];
                else
                    sortedTree[idx2--] = tree[i];
            }

            getAnswer();
        }
    }

    static void getAnswer() {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<sortedTree.length-1; i++)
            max = Math.max(max, Math.abs(sortedTree[i] - sortedTree[i+1]));

        System.out.println(max);
    }
}
