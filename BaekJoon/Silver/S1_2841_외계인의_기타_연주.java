package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_2841_외계인의_기타_연주 {

    private static int N;
    private static int P;
    private static int fingerMovementCount = 0;

    private static int[] line;
    private static int[] fret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        line = new int[N];
        fret = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            line[i] = Integer.parseInt(st.nextToken());
            fret[i] = Integer.parseInt(st.nextToken());
        }

        countFingerMovement();

        System.out.println(fingerMovementCount);
    }

    public static void countFingerMovement() {
        Stack<Integer> stack;
        Map<Integer, Stack<Integer>> map = new HashMap<>();

        for(int i=0; i<N; i++) {
            if(!map.containsKey(line[i])) {
                stack = new Stack<>();
                map.put(line[i], stack);
            }
            else
                stack = map.get(line[i]);

            if(stack.isEmpty()) {
                stack.push(fret[i]);
                fingerMovementCount++;
            }
            else {
                while(true) {
                    if(stack.isEmpty() || stack.peek() < fret[i]) {
                        stack.push(fret[i]);
                        fingerMovementCount++;
                        break;
                    }
                    else if(stack.peek() == fret[i])
                        break;
                    else {
                        stack.pop();
                        fingerMovementCount++;
                    }
                }
            }
        }
    }
}
