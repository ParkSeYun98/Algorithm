/*
* Memory : 214244 KB
* Time : 2708 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

public class G5_6443_애너그램 {

    private static int N;

    private static char[] chArr;
    private static int[] check;

    private static PriorityQueue<String> pq;
    private static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String temp = br.readLine();
            chArr = temp.toCharArray();

            check = new int[26];
            pq = new PriorityQueue<>();
            stack = new Stack<>();

            for (char c : chArr)
                check[c - 'a']++;

            getAnagram();

            for (String s : pq)
                System.out.println(s);
        }
    }

    public static void getAnagram() {
        if(stack.size() == chArr.length) {
            StringBuilder sb = new StringBuilder();

            for (Character c : stack)
                sb.append(c);

            pq.offer(sb.toString());
        }

        for(int i=0; i<check.length; i++) {
            if(check[i] > 0) {
                check[i]--;
                stack.push((char) (i + 'a'));
                getAnagram();
                stack.pop();
                check[i]++;
            }
        }
    }
}
