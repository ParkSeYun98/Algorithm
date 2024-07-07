package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G4_9935_문자열_폭발 {

    static String str, bomb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        bomb = br.readLine();

        explosion();
    }

    static void explosion() {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= bomb.length()) {
                boolean flag = true;

                for(int j=0; j<bomb.length(); j++) {
                    if(stack.get(stack.size()-bomb.length()+j) != bomb.charAt(j)) {
                           flag = false;
                           break;
                    }
                }

                if(flag) {
                    for(int j=0; j<bomb.length(); j++)
                        stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if(stack.isEmpty())
            System.out.println("FRULA");
        else {
            while(!stack.isEmpty())
                sb.append(stack.pop());

            System.out.println(sb.reverse());
        };
    }
}
