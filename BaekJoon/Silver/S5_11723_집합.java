package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11723_집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int S = 0;
        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            if(order.equals("all"))
                S = (1 << 21) - 1;
            else if(order.equals("empty"))
                S = 0;
            else {
                int num = Integer.parseInt(st.nextToken());

                switch (order) {
                    case "add" -> S |= (1 << num);
                    case "remove" -> S &= ~(1 << num);
                    case "check" -> sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                    case "toggle" -> S ^= (1 << num);
                }
            }
        }

        System.out.print(sb);
    }
}
