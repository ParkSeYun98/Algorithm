package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1821_수들의_합_6 {

    static int N, last;
    static boolean flag;

    static int[] firstLine, factorial, mul;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        last = Integer.parseInt(st.nextToken());

        flag = false;
        factorial = new int[N];
        mul = new int[N];
        firstLine = new int[N+1];
        visited = new boolean[N+1];

        factorial[0] = 1;

        for(int i=1; i<N; i++)
            factorial[i] = factorial[i-1] * i;

        setMul();
        getFirstLine(0, 0);
    }

    static void getFirstLine(int depth, int partSum) {
        if(depth == N) {
            if(partSum == last){
                for(int i=0; i<N; i++)
                    System.out.print(firstLine[i] + " ");

                flag = true;
            }

            return;
        }

        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                firstLine[depth] = i;
                getFirstLine(depth+1, partSum + mul[depth] * i);

                if(flag)
                    break;

                visited[i] = false;
            }
        }
    }

    static void setMul(){
        for(int i=0; i<N; i++)
            mul[i] = factorial[N-1] / (factorial[N-1-i] * factorial[i]);
    }
}
