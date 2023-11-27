/*
* Memory : 253316 KB
* Time : 1268 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S2_5397_키로거 {

    private static Stack<Character> mainStack;
    private static Stack<Character> subStack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        mainStack = new Stack<>();
        subStack = new Stack<>();

        for(int i = 0; i< tc; i++) {
            String input = br.readLine();

            getPassword(input);
        }
    }

    public static void getPassword(String input) {
        for(int i=0; i<input.length(); i++) {
            char temp = input.charAt(i);

            if(temp == '<') {
                if (!mainStack.isEmpty())
                    subStack.push(mainStack.pop());
            }
            else if(temp == '>') {
                if(!subStack.isEmpty())
                    mainStack.push(subStack.pop());
            }
            else if(temp == '-') {
                if (!mainStack.isEmpty())
                    mainStack.pop();
            }
            else
                mainStack.push(temp);
        }

        StringBuilder sb = new StringBuilder();

        while(!mainStack.isEmpty())
            sb.append(mainStack.pop());

        sb.reverse();

        while(!subStack.isEmpty())
            sb.append(subStack.pop());

        System.out.print(sb);
        System.out.println();
    }
}
