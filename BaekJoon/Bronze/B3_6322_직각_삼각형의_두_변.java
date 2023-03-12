package BaekJoon.Bronze;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.StringTokenizer;

public class B3_6322_직각_삼각형의_두_변 {
    private static Map<Character, Integer> triangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = 0;
        while(true) {
            k++;

            triangle = new HashMap<>();

            st = new StringTokenizer(br.readLine(), " ");
            int tempA = Integer.parseInt(st.nextToken());
            triangle.put('a', tempA);
            int tempB = Integer.parseInt(st.nextToken());
            triangle.put('b', tempB);
            int tempC = Integer.parseInt(st.nextToken());
            triangle.put('c', tempC);

            if(tempA == 0 && tempB == 0 && tempC == 0)
                System.exit(0);

            System.out.println("Triangle #" + k);
            print();
        }
    }

    public static boolean check() {
        if(triangle.get('c') == -1)
            return true;
        else return triangle.get('a') < triangle.get('c') && triangle.get('b') < triangle.get('c');
    }

    public static void print() {
        if(check()) {
            if(triangle.get('c') == -1)
                System.out.println("c = " + String.format("%.3f", (Math.sqrt(Math.pow(triangle.get('a'), 2) + Math.pow(triangle.get('b'), 2)))));
            else if(triangle.get('a') == -1)
                System.out.println("a = " + String.format("%.3f", (Math.sqrt(Math.pow(triangle.get('c'), 2) - Math.pow(triangle.get('b'), 2)))));
            else if(triangle.get('b') == -1)
                System.out.println("b = " + String.format("%.3f", (Math.sqrt(Math.pow(triangle.get('c'), 2) - Math.pow(triangle.get('a'), 2)))));
        }
        else
            System.out.println("Impossible.");

        System.out.println();
    }
}