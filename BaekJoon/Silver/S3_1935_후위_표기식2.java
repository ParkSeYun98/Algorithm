package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S3_1935_후위_표기식2 {

    static int N;
    static String input;

    static double[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        input = br.readLine();

        value = new double[N];

        for(int i=0; i<N; i++)
            value[i] = Double.parseDouble(br.readLine());

        Stack<Double> stack = new Stack<>();

        for(int i=0; i<input.length(); i++) {
            char now = input.charAt(i);

            if(now>='A' && now<='Z')
                stack.push(value[now-'A']);
            else {
                if(!stack.isEmpty()) {
                    double A = stack.pop();
                    double B = stack.pop();

                    switch (now) {
                        case '+' :
                            stack.push(B+A);
                            continue;
                        case '-' :
                            stack.push(B-A);
                            continue;
                        case '*' :
                            stack.push(B*A);
                            continue;
                        case '/' :
                            stack.push(B/A);
                            continue;
                    }
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
