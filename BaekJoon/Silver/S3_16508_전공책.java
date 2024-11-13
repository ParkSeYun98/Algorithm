package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_16508_전공책 {

    static String T;
    static int N, min;

    static boolean[] visited;
    static int[] selectedBookArr;
    static Book[] bookArr;

    static class Book {
        String name;
        int price;

        public Book(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = br.readLine();

        N = Integer.parseInt(br.readLine());

        bookArr = new Book[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int C = Integer.parseInt(st.nextToken());
            String W = st.nextToken();

            bookArr[i] = new Book(W, C);
        }

        min = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++) {
            visited = new boolean[N];
            selectedBookArr = new int[i];
            selectBook(0, 0, 0, i);
        }

        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void selectBook(int depth, int sum, int start, int bookCnt) {
        if(depth == bookCnt) {
            if(wordCheck())
                min = Math.min(min, sum);

            return;
        }

        for(int i=start; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selectedBookArr[depth] = i;
                selectBook(depth+1, sum+bookArr[i].price, i+1, bookCnt);
                visited[i] = false;
            }
        }
    }

    static boolean wordCheck() {
        char[] chArr = T.toCharArray();
        boolean[] check = new boolean[T.length()];

        for(int i=0; i<selectedBookArr.length; i++) {
            String now = bookArr[selectedBookArr[i]].name;

            for(int j=0; j<now.length(); j++) {
                char ch = now.charAt(j);

                for(int k=0; k<chArr.length; k++) {
                    if(check[k])
                        continue;

                    if(ch == chArr[k]) {
                        check[k] = true;
                        break;
                    }
                }
            }
        }

        for(int i=0; i<chArr.length; i++) {
            if(!check[i])
                return false;
        }

        return true;
    }
}
