package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_5430_AC {

    static int n;
    static String p;
    static boolean flag;

    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        outer : for(int tc=0; tc<T; tc++) {
            p = br.readLine();

            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), ",");

            flag = false;
            String temp = "";
            deque = new ArrayDeque<>();

            while(n-- > 0) {
                temp = st.nextToken();

                if(temp == null)
                    break;

                String tmp = "";

                for(int i=0; i<temp.length(); i++) {
                    char now = temp.charAt(i);

                    if(now == '[' || now == ']')
                        continue;

                    tmp += now;
                }

                deque.add(Integer.parseInt(tmp));
            }

            for(int i=0; i<p.length(); i++) {
                if(p.charAt(i) == 'R')
                    R();
                else if(p.charAt(i) == 'D') {
                    if(deque.isEmpty()) {
                        System.out.println("error");

                        continue outer;
                    }

                    D();
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append('[');

            while(!deque.isEmpty()) {
                if(!flag)
                    sb.append(deque.pollFirst());
                else
                    sb.append(deque.pollLast());

                if(!deque.isEmpty())
                    sb.append(',');
            }

            sb.append(']');

            System.out.println(sb);
        }
    }

    static void R() {
        flag = !flag;
    }

    static void D() {
        if(!flag)
            deque.pollFirst();
        else
            deque.pollLast();
    }
}
